<!DOCTYPE html SYSTEM "about:legacy-compat">
<!-- saved from url=(0041)https://tomcat.apache.org/download-90.cgi -->
<%@ page session="false" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="./resources/tomcat.css" rel="stylesheet" type="text/css">
<link href="./resources/fonts.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.json.js"></script>

<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>

<script type="text/javascript" src="js/tabulator.min.js"></script>
<script type="text/javascript" src="js/tabulator.js"></script>
<title>飞狐数据</title>

</head>
<body>
	<script>
		$(function() {
			$("#hangqing_download_btn").click(function() {
			    $("#fbean").attr("action","hangqing_download");
			    $("#fbean").submit();
			});
		});
	</script>
	<div id="wrapper">
		<header id="header">
		 <jsp:include page="toolBar.jsp"/>

		</header>
		<main id="middle">
		<div>
			<div id="mainLeft">
				<div id="nav-wrapper">
					<nav>
						<div>
							<h2>行情补全</h2>
							<ul>
								<li><a href="HangQing">飞狐导入行情数据下载</a>
								</li>
							</ul>
						</div>
						<div>
							<h2>除权补全</h2>
							<ul>
								<li><a href="ChuQuan">飞狐导入除权数据下载</a>
								</li>
							</ul>
						</div>
						<div>
							<h2>财务补全</h2>
							<ul>
								<li><a href="CaiWu">飞狐导入财务数据下载</a>
								</li>
							</ul>
						</div>

					</nav>
				</div>
			</div>
			<div id="mainRight">
				<div id="content">
					<h2 style="display: none;">Content</h2>
					<h3 id="Tomcat_9_Software_Downloads">行情补全</h3>
					<div class="text">
						<p>处理流程：先从通达信券商服务器下载最后交易日的全部有效证券代码、
							再根据代码下载每只股票的历史行情数据，之后将下载数据出力到文件和数据库进行备份 最后，最后将数据做成飞狐导入用下载文件。</p>
						<input type="button" id="hangqing_download_btn" value="飞狐导入行情数据下载">
					</div>

				</div>
			</div>
		</div>
		<form id ="fbean" name="fbean" method="post">
		</form>
		</main>
		<footer id="footer">
			所有权 © 2017-2019, 颜老师工作室 <br>
		</footer>
	</div>



</body>
</html>