package com.scarlatti.taskLauncher;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Tuesday, 3/20/2018
 */
public class GuiTaskLauncher {

    protected List<Task> tasks;
    protected LauncherFrame frame;
    protected CountDownLatch latch;

    GuiTaskLauncher(TaskLauncherBuilder builder) {
        tasks = builder.getTasks();
    }

    public static TaskLauncherBuilder gui() {
        return new TaskLauncherBuilder();
    }

    /**
     * Non-blocking call to show gui.
     */
    public void show() {
        setLookAndFeel();
        frame = buildFrame();
        addTasks();

        latch = new CountDownLatch(1);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                latch.countDown();
            }
        });

        try {
            EventQueue.invokeAndWait(() -> {
                try {
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void addTasks() {
        for (Task task : tasks) {
            addTask(task);
        }
    }

    protected void addTask(Task task) {
        frame.addTask(task);
    }

    protected LauncherFrame buildFrame() {
        LauncherFrame frame = new LauncherFrame(getTitle());
        frame.buildContent();
        frame.setIcon();

        return frame;
    }

    protected static class LauncherFrame extends JFrame {

        private JPanel tasksPanel;
        private Image buttonImage;

        private LauncherFrame(String title) {
            super(title);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(100, 100, 335, 153);
            JPanel contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(new BorderLayout(0, 0));
        }

        protected void buildContent() {
            {
                tasksPanel = new JPanel();
                getContentPane().add(tasksPanel, BorderLayout.CENTER);
                tasksPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            }
        }

        protected void setIcon() {
            try {
                List<Image> icons = new ArrayList<>();
                icons.add(ImageIO.read(this.getClass().getResource("/com.scarlatti.taskLauncher/go32.png")));
                icons.add(ImageIO.read(this.getClass().getResource("/com.scarlatti.taskLauncher/go48.png")));

                setIconImages(icons);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected void addTask(Task task) {
            JButton button = new JButton(task.getName());
            tasksPanel.add(button);

            button.addActionListener((ActionEvent event) -> {
                runTask(task);
            });

            if (buttonImage == null) {
                try {
                    buttonImage = ImageIO.read(this.getClass().getResource("/com.scarlatti.taskLauncher/go32.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            button.setIcon(new ImageIcon(buttonImage));
        }

        protected void runTask(Task task) {
            new Thread(() -> {
                try {
                    task.getRunnable().run();
                } catch (Exception e) {
                    System.err.println("Error running task " + task);
                    e.printStackTrace();
                }
            }, getTaskThreadName(task)).start();
        }

        protected String getTaskThreadName(Task task) {
            return task.getName() + "-" + LocalTime.now().toString();
        }
    }

    protected String getTitle() {
        return "Task Launcher";
    }

    protected void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
