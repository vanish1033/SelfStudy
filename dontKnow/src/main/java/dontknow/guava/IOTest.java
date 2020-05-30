package dontknow.guava;

import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author:whr 2019/11/23
 */
public class IOTest {

    @Test
    public void copyFile() throws IOException {
        ByteSource byteSource = Files.asByteSource(new File("D:\\动力节点夜校\\1、Java进阶资料包必备\\告别996，开启Java高效编程之门\\第5章 告别996之工具集 【背靠Google好乘凉】\\5-9 实战：IO_慕课网 2019-11-10 20_12.mp4"));
        ByteSink byteSink = Files.asByteSink(new File("D:\\动力节点夜校\\1、Java进阶资料包必备\\告别996，开启Java高效编程之门\\第5章 告别996之工具集 【背靠Google好乘凉】\\123.mp4"));
        byteSource.copyTo(byteSink);
//------------------------------------------------------------------------------------------------------
        String from = "D:\\动力节点夜校\\1、Java进阶资料包必备\\告别996，开启Java高效编程之门\\第5章 告别996之工具集 【背靠Google好乘凉】\\5-9 实战：IO_慕课网 2019-11-10 20_12.mp4";
        String to = "D:\\动力节点夜校\\1、Java进阶资料包必备\\告别996，开启Java高效编程之门\\第5章 告别996之工具集 【背靠Google好乘凉】\\123.mp4";
        Files.copy(new File(from), new File(to));
    }

}
