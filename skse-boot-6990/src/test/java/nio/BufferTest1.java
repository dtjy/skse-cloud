package nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.SortedMap;

/**
 * @author skse
 * @date 2021/1/30 14:12
 */
public class BufferTest1 {

    @Test
    public void test1(){
        //创建一个大小为5的Buffer，可存放5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);

        //向buffer存数据
        for (int i=0; i<intBuffer.capacity()-1; i++){
            intBuffer.put(i);
        }

        //将buffer转换，读写切换
        intBuffer.flip();

        //使用get(),postion值会改变，同时get的值会是下一个
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.position());
        System.out.println(">>>>>>>>>>>>>>>>>>");
        //使用get(index),类似于直接获取下标，postion不会发生改变
//        System.out.println(intBuffer.get(4));
//        System.out.println(intBuffer.position());
//        System.out.println(intBuffer.get());
//        System.out.println(intBuffer.position());
//        System.out.println(">>>>>>>>>>>>>>>>>>");
        //intBuffer.position(1)重新设置postion
//        System.out.println(intBuffer.position(1));
//        System.out.println(intBuffer.position());
//        System.out.println(intBuffer.get());
//        System.out.println(">>>>>>>>>>>>>>>>>>");
        System.out.println(intBuffer.limit());
    }

    /**
     * 写文件
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("fileout.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();
        String str = "今天明天大后天！";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        fileChannel.write(buffer);
        fileOutputStream.close();
    }

    /**
     * 写文件
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("fileout.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fileChannel.read(buffer);
        buffer.flip();
        System.out.println(new String(buffer.array()));
//        while (buffer.hasRemaining()){
//            System.out.println(new String());
//        }
    }



}
