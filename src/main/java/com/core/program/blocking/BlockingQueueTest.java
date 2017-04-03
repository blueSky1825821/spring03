package com.core.program.blocking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by sky on 2017/4/1.
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base directory (e.g. /usr/local): ");
        String directory = in.nextLine();
        System.out.println("Enter keyword (e.g. volatile): ");
        String keyword = in.nextLine();
        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;

        BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
        FileEnumerationTask enumeration = new FileEnumerationTask(queue, new File(directory));
        new Thread(enumeration).start();
        for (int i = 0; i < SEARCH_THREADS; i++) {
            new Thread(new SearchTask(queue, keyword)).start();
        }
    }

}

class FileEnumerationTask implements Runnable {
    public static File DUMMY = new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;

    /**
     * @param queue             the blocking queue to which the enumerated files are added
     * @param startingDirectory the directory in which to start the enumeration
     */

    public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    @Override
    public void run() {
        try {
            enumrate(startingDirectory);
            queue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param directory Recursively(递归地) enumerates all files in a given direcory and its subdirectories.
     * @throws InterruptedException
     */
    public void enumrate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumrate(file);
            } else {
                queue.put(file);
                System.out.println(Thread.currentThread().getId() + "放文件" + file.getName());
            }
        }
    }

}

/**
 * This task searches files for a given keyword.
 */
class SearchTask implements Runnable {
    private BlockingQueue<File> queue;
    private String keyword;

    /**
     * @param queue   the queue from which to take files
     * @param keyword the keyword to look for
     */
    public SearchTask(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        boolean done = false;
        while (!done) {
            try {
                File file = queue.take();
                System.out.println(Thread.currentThread().getId() + "取文件" + file.getName());
                if (file == FileEnumerationTask.DUMMY) {
                    queue.put(file);
                    System.out.println(Thread.currentThread().getId() + "放文件" + file.getName());
                    done = true;
                } else {
                    search(file);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void search(File file) {
        try (Scanner in = new Scanner(file)) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}