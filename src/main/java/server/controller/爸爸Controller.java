package server.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class 爸爸Controller {

	public 爸爸Controller() {

	}

	public void 将指定文件提供下载_byHttpServletResponse_文件全路径(HttpServletResponse response, String s文件全路径) {

        try {
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            BufferedInputStream fIn=new BufferedInputStream(new FileInputStream(s文件全路径));
    		int len=0;
    		byte[] buf=new byte[1024];
    		int i=0;
    		while((len=fIn.read(buf))!=-1)
    		{
    			bufferedOutPut.write(buf,0,len);
    			System.out.println(++i);
    		}
            bufferedOutPut.flush();
            bufferedOutPut.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
