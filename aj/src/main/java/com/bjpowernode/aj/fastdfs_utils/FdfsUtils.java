package com.bjpowernode.aj.fastdfs_utils;


import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author:whr 2019/10/28
 */
public class FdfsUtils {
    public static void main(String[] args) throws IOException, MyException {

//        IOUtils.readFully();

        ClientGlobal.init("fdfs_client.conf");

        TrackerClient trackerClient = new TrackerClient();

        TrackerServer connection = trackerClient.getConnection();

        StorageClient storageClient = new StorageClient(connection, null);

        String[] txts = storageClient.upload_file("D://aa.txt", "txt", null);

        Arrays.stream(txts).forEach(System.out::println);

    }
}
