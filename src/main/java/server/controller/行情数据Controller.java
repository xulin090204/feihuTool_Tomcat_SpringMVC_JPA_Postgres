package server.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import server.service.行情数据Service;
@Controller
public class 行情数据Controller  extends 爸爸Controller{

	public 行情数据Controller() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@RequestMapping(value = "hangqing_download", method = RequestMethod.POST)
	public void 取得行情导入数据(HttpServletResponse response) {
		行情数据Service 行情数据service = new 行情数据Service();

		//
		String s文件全路径;

		s文件全路径 = 行情数据service.下载行情导入数据();

		// 将文件提供下载
		将指定文件提供下载_byHttpServletResponse_文件全路径(response, s文件全路径);

	}


	@RequestMapping(value = "HangQing", method = RequestMethod.GET)
	public String 行情信息(Locale locale, Model model) {
		return "行情补全";

	}
}
