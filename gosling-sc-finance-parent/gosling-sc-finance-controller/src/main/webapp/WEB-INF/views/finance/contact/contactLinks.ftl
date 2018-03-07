<!-- 头部-->
<#include "/finance/commons/_head.ftl" />

<link rel="stylesheet" href="${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/css/datalist.css" type="text/css">

<style type="text/css">
#content {
	/*margin-top:-20px;*/
	padding-left: 0px;
}

.widget-box,.row {
	padding-left: 10px;
	margin-top: 0px;
}

.tu_box {
	width: 180px;
}

.tu_ko {
	width: 80px;
	height: 40px;
	border: solid 1px #000000;
	text-align: center;
}

.table-responsive th {
	font-size: 1em;
}

.table-responsive th,.table-responsive td {
	white-space: nowrap;
	padding-left: 12px;
	padding-right: 12px;
}

.input-group {
	margin-left: 20%;
}

.form-control {
	margin-right: 4px;
}

@media ( max-width :480px) {
	.input-group {
		margin-left: -15px;
	}
}
</style>
<!-- Content -->
<div id="content">
	<!-- page specific plugin styles -->
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row">
				<div class="col-sm-12">
					 <a href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/contactLinks.html" class="btn btn-danger">安置图谱</a>

					<div class="widget-box">
						<!-- 架构图部分-->
						<table border="0" cellspacing="1" cellpadding="0" width="100%">
							<tr>
								<td>
								
								<table width='100%' border='0' cellpadding='1' cellspacing='1'>
										<tr align='center'>
											<#list members as member1>
											<td class='borderlrt' width='100%' valign='top' title='第1层'>
											<img width='12' height='0'><br />
											<table border='0' cellpadding='0' cellspacing='1' class='tu_box'>
													<tr>
														<td align='center' colspan='3'>
															<button type='button' class='btn btn-warning' style='width:100% ;background-color:#ff9933'>
																<a style='WIDTH: 180px;' href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/contactLinks.html?memNum=${(member1.memNum)!''}"> <font color='#ffffff'><strong>${(member1.memNum)!'0'}</strong></font> </a>
															</button>
														</td>
													</tr>
													<tr>
														<td align='center'>
														<button type='button'  class='btn btn-default' style='width:40px;height:50px'>统计</button>
														</td>
														<td align='center'>
															<button type='button' class='btn btn-default'
																style='width:70px; height: 50px;'>A区</button>
														</td>
														<td align='center'>
															<button type='button' class='btn btn-default'
																style='width:70px;height: 50px;'>B区</button>
														</td>
													</tr>
													<tr>
														<td>
														<button type='button' class='btn btn-default' style='width:40px'>总</button></td>
														<td align='center'><button type='button' class='btn btn-default' style='width:100%'>${(member1.aCounts)!''}</button></td>
														<td align='center'><button type='button' class='btn btn-default' style='width:100%'>${(member1.bCounts)!''}</button></td>
													</tr>
													<tr>
														<td align='center' colspan='3'><button type='button' class='btn btn-default' style='width:100%'>
															<#if member1.jhTime??>
																${(member1.jhTime)?datetime}
															<#else>
															未激活
															</#if>
														</button></td>
													</tr>
												</table>
											</td>
										</#list>
										</tr>
										<tr align='center'>
											<td class='borderno' width='100%' valign='top'>
												<img src='${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/tree/t_tree_bottom_l.gif' height='20'>
												<img src='${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/tree/t_tree_line.gif' width='25%' height='20'>
												<img src='${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/tree/t_tree_top.gif' height='20' alt='顶层'>
												<img src='${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/tree/t_tree_line.gif' width='25%' height='20'>
												<img src='${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/tree/t_tree_bottom_r.gif' height='20'>
											</td>
										</tr>
								</table>
								
								<table width='100%' border='0' cellpadding='1' cellspacing='1'>
									<tr align='center'>
										<#list members as member1>
										<#if member1.nodes?? && member1.nodes?size=2 >
										<#list member1.nodes as member2>
										<td class='borderlrt' width='50%' valign='top' title='第2层'>
										<img width='12' height='0'><br />
											<table border='0' cellpadding='0' cellspacing='1' class='tu_box'>
												<tr>
													<td align='center' colspan='3'>
														<div class='btn btn-warning' style='width:100%;background-color:#ff9933'>
															<a style='WIDTH: 180px;' href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/contactLinks.html?memNum=${(member2.memNum)!''}">${(member2.memNum)!''}</a>
														</div>
													</td>
												</tr>
												<tr>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:40px;height:50px'>统计</button>
													</td>
													<td align='center'>
														<button type='button' class='btn btn-default'
															style='width:70px; height: 50px;'>A区</button>
													</td>
													<td align='center'>
														<button type='button' class='btn btn-default'
															style='width:70px;height: 50px;'>B区</button>
													</td>
												</tr>
												<tr>
													<td><button type='button' class='btn btn-default'
															style='width:40px'>总</button></td>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:100%'>${(member2.aCounts)!''}</button></td>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:100%'>${(member2.bCounts)!''}</button></td>
												</tr>
												<tr>
													<td align='center' colspan='3'>
														<#if member2.jhState?? && member2.jhState=2>
														<button type='button' class='btn btn-default' style='width:100%'>${(member2.jhTime)?datetime}</button>
														<#else>
														<button type='button' class='btn btn-default' style='width:100%'>未激活</button>
														</#if>
													</td>
												</tr>
											</table>
										</td>
										</#list>
										<#elseif member1.nodes?? && member1.nodes?size=1 >
										<#list member1.nodes as member2>
										<td class='borderlrt' width='50%' valign='top' title='第2层'>
										<img width='12' height='0'><br />
											<table border='0' cellpadding='0' cellspacing='1' class='tu_box'>
												<tr>
													<td align='center' colspan='3'>
														<div class='btn btn-warning' style='width:100%;background-color:#ff9933'>
															<a style='WIDTH: 180px;' href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/contactLinks.html?memNum=${(member2.memNum)!''}">${(member2.memNum)!''}</a>
														</div>
													</td>
												</tr>
												<tr>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:40px;height:50px'>统计</button>
													</td>
													<td align='center'>
														<button type='button' class='btn btn-default'
															style='width:70px; height: 50px;'>A区</button>
													</td>
													<td align='center'>
														<button type='button' class='btn btn-default'
															style='width:70px;height: 50px;'>B区</button>
													</td>
												</tr>
												<tr>
													<td><button type='button' class='btn btn-default'
															style='width:40px'>总</button></td>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:100%'>${(member2.aCounts)!''}</button></td>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:100%'>${(member2.bCounts)!''}</button></td>
												</tr>
												<tr>
													<td align='center' colspan='3'>
														<#if member2.jhState?? && member2.jhState=2>
														<button type='button' class='btn btn-default' style='width:100%'>${(member2.jhTime)?datetime}</button>
														<#else>
														<button type='button' class='btn btn-default' style='width:100%'>未激活</button>
														</#if>
													</td>
												</tr>
											</table>
										</td>
										</#list>
										<td class='borderlrt' width='50%' valign='top' title='第二层'>
											<img width='12' height='0'><br />
											<table border='0' cellpadding='0' cellspacing='1'
													class='tu_box'>
													<tr>
													</tr>
											</table>
										</td>
										</#if>
										</#list>
									</tr>
									<tr align='center'>
										<#list members as member1>
										<#list member1.nodes as member2>
										<td class='borderno' width='50%' valign='top'>
											<img src='${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/tree/t_tree_bottom_l.gif' height='20'>
											<img src='${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/tree/t_tree_line.gif' width='25%' height='20'>
											<img src='${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/tree/t_tree_top.gif' height='20' alt='顶层'>
											<img src='${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/tree/t_tree_line.gif' width='25%' height='20'>
											<img src='${(domainUrlUtil.GOSLING_STATIC_RESOURCES)!}/finance/images/tree/t_tree_bottom_r.gif' height='20'>
										</td>
										</#list>
										</#list>
									</tr>
								</table>
								
									
								<table width='100%' border='0' cellpadding='1' cellspacing='1'>
									<tr align='center'>
								<#list members as member1>
											<!-- 数量四个 -->
										<#list member1.nodes as member2>
										<#if member2.nodes?? && member2.nodes?size=2 >
										<#list member2.nodes as member3>
											<td class='borderlrt' width='25%' valign='top' title='第3层'>
											<img width='12' height='0'><br />
											<table border='0' cellpadding='0' cellspacing='1' class='tu_box'>
												<tr>
													<td align='center' colspan='3'>
														<div class='btn btn-warning' style='width:100%;background-color:#ff9933'>
															<a style='WIDTH: 180px;' href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/contactLinks.html?memNum=${(member3.memNum)!''}">${member3.memNum}</a>
														</div>
													</td>
												</tr>
												<tr>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:40px;height:50px'>统计</button>
													</td>
													<td align='center'>
														<button type='button' class='btn btn-default'
															style='width:70px; height: 50px;'>A区</button>
													</td>
													<td align='center'>
														<button type='button' class='btn btn-default'
															style='width:70px;height: 50px;'>B区</button>
													</td>
												</tr>
												<tr>
													<td><button type='button' class='btn btn-default'
															style='width:40px'>总</button></td>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:100%'>${(member3.aCounts)!''}</button></td>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:100%'>${(member3.bCounts)!''}</button></td>
												</tr>
												<tr>
													<td align='center' colspan='3'>
													<#if member3.jhState?? && member3.jhState=2>
													<button type='button' class='btn btn-default' style='width:100%'>${(member3.jhTime)?datetime}</button>
													<#else>
													<button type='button' class='btn btn-default' style='width:100%'>未激活</button>
													</#if>
													</td>
												</tr>
											</table>
										</td>
										</#list>
										</#if>
										</#list>
								</#list>
								
								<#list members as member1>
											<!-- 数量四个 -->
										<#list member1.nodes as member2>
										<#if member2.nodes?? && member2.nodes?size=1 >
										<#list member2.nodes as member3>
											<td class='borderlrt' width='25%' valign='top' title='第3层'>
											<img width='12' height='0'><br />
											<table border='0' cellpadding='0' cellspacing='1' class='tu_box'>
												<tr>
													<td align='center' colspan='3'>
														<div class='btn btn-warning' style='width:100%;background-color:#ff9933'>
															<a style='WIDTH: 180px;' href="${(domainUrlUtil.GOSLING_URL_RESOURCES)!}/contactLinks.html?memNum=${(member3.memNum)!''}">${member3.memNum}</a>
														</div>
													</td>
												</tr>
												<tr>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:40px;height:50px'>统计</button>
													</td>
													<td align='center'>
														<button type='button' class='btn btn-default'
															style='width:70px; height: 50px;'>A区</button>
													</td>
													<td align='center'>
														<button type='button' class='btn btn-default'
															style='width:70px;height: 50px;'>B区</button>
													</td>
												</tr>
												<tr>
													<td><button type='button' class='btn btn-default'
															style='width:40px'>总</button></td>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:100%'>${(member3.aCounts)!''}</button></td>
													<td align='center'><button type='button'
															class='btn btn-default' style='width:100%'>${(member3.bCounts)!''}</button></td>
												</tr>
												<tr>
													<td align='center' colspan='3'>
													<#if member3.jhState?? && member3.jhState=2>
													<button type='button' class='btn btn-default' style='width:100%'>${(member3.jhTime)?datetime}</button>
													<#else>
													<button type='button' class='btn btn-default' style='width:100%'>未激活</button>
													</#if>
													</td>
												</tr>
											</table>
										</td>
										</#list>
										<td class='borderlrt' width='25%' valign='top' title='第3层'>
											<img width='12' height='0'><br />
											<table border='0' cellpadding='0' cellspacing='1'
													class='tu_box'>
													<tr>
													</tr>
											</table>
										</td>
										</#if>
										</#list>
								</#list>
								
								
								<#list members as member1>
											<!-- 数量四个 -->
										<#list member1.nodes as member2>
										<#if member2.nodes?? && member2.nodes?size=0 >
										<td class='borderlrt' width='25%' valign='top' title='第3层'>
											<img width='12' height='0'><br />
											<table border='0' cellpadding='0' cellspacing='1'
													class='tu_box'>
													<tr>
													</tr>
											</table>
										</td>
										<td class='borderlrt' width='25%' valign='top' title='第3层'>
											<img width='12' height='0'><br />
											<table border='0' cellpadding='0' cellspacing='1'
													class='tu_box'>
													<tr>
													</tr>
											</table>
										</td>
										</#if>
										</#list>
								</#list>
								
								
									</tr>
								</table>
								
								
							  </td>
							</tr>
						</table>
					<!-- 架构图部分end-->

					</div>
				</div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.page-content -->
	<!-- page specific plugin scripts -->
	<!--[if lte IE 8]>
  <script src="/assets/js/excanvas.min.js"></script>
<![endif]-->
</div>
</div>
<!-- 底部-->
<#include "/finance/commons/_footer.ftl" />
<#include "/finance/commons/_iframejs.ftl" />