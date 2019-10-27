package server.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ConvertTool.impl.StockData财务ConvertTool;
import InputData.InputDataUtil财务;
import server.dao.财务信息Dao;
import server.entity.财务Entity;

@Service
public class 财务数据Service  extends 爸爸数据Service{

	@Autowired
	财务信息Dao 财务信息dao;

	public 财务数据Service() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 * 下载除权导入数据
	 * @return
	 */
	public String 下载财务导入数据() {

		String[] s财务原始文件全路径 = new String[1];
		s财务原始文件全路径[0]="D:\\pleiades\\workspace\\股票数据\\财务数据.data";

		String s财务导出文件全路径 = null;

		s财务导出文件全路径 = new StockData财务ConvertTool().输出到财务文件(s财务原始文件全路径);

		if(StringUtils.isEmpty(s财务导出文件全路径)) {
			return s财务导出文件全路径;
		}
		// 存储除权数据（解析原始文件、存入数据库）
		List<String> 财务数据list = InputDataUtil财务.getFileContext2(s财务原始文件全路径[0]);
		存储财务数据_by财务数据(财务数据list);

		return s财务导出文件全路径;
	}



	/**
	 * 存储除权数据_by除权数据
	 * @param 除权数据list
	 */
	private void 存储财务数据_by财务数据(List<String> 财务数据list) {
		List<财务Entity> 财务EntityList = new ArrayList<财务Entity>();
		for(String in每股财务Data : 财务数据list) {
	           System.out.println(in每股财务Data);

				List<财务Entity> 财务DataInputBean飞狐list = 解析每一行的财务数据2(
						in每股财务Data);

				财务EntityList.addAll(财务DataInputBean飞狐list);
		}

		// 将【out除权DataInputBean飞狐list】写入数据库
		财务信息dao.save(财务EntityList);
	}

	/**
	 * 解析每一行的除权数据2
	 * @param in每股除权Data
	 * @return
	 *
	 *  为何在此另写一个解析函数呢
	 *  因为，需要返回<除权Entity>这个类型
	 *  这个类型是数据库专用的
	 *  与解析函数的bean不同
	 *  所以，需要另写函数
	 */
	public List<财务Entity> 解析每一行的财务数据2(String in每股财务Data) {

		// 把数据分解成数组
		byte[] resultByte深沪个股财务输出数据 = new byte[0];
		String[] s每条财务数据 = in每股财务Data.split("\\n");
		int iIndex = 0;
		int i财务数据个数 = 0;
		List<财务Entity> 财务Entitylist = new ArrayList<财务Entity>();

		for(String s每项财务数据  : s每条财务数据) {
			if(iIndex == 0) {
				iIndex++;
				continue;
			}

			财务Entity 财务entity = new 财务Entity();

			// 从第二条开始分析
			String[] s = s每项财务数据.split("\\t");
			if (s.length != 7) return null;
			// 判断是不是实际的数据
			if(new StockData财务ConvertTool().判断是不是有效的财务数据ForDLLData(s)) {
				// 只有实际的数据才进行后续处理
				// 先取得股票代号，做成文件名
				// 再取得入力的值
				// 输出实体文件

				// 先取得股票代号，做成文件名
				// 市场 证券代码 日期 权息数据类别 派息金额 配股价 送股数 配股数

				// 先取得股票代号，做成文件名
				String s市场代码      = s[0];
				String s股票代码 = s[1];
				String sUTCtime      = s[2];
				String s流通股本 = s[3];
			    String s所属省份   = s[4];
				String s所属行业   = s[5];
				String s账务更新日期   = s[6];
			//String[] sData = new String[] {s市场代码, s股票代码,sUTCtime,s流通股本,s所属省份,s所属行业,s账务更新日期 };

				财务entity.set市场代码(s市场代码);
				财务entity.set股票代码(s股票代码);
				财务entity.setUTCtime(sUTCtime);
				财务entity.set流通股本(s流通股本);
				财务entity.set所属省份(s所属省份);
				财务entity.set所属行业(s所属行业);
				财务entity.set账务更新日期(s账务更新日期);

				财务Entitylist.add(财务entity);
			}

		}

		return 财务Entitylist;
	}

}
