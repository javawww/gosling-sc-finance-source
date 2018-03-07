<!-- 左侧信息栏-->
  <div class="l_270">
    <div class="h_120 h_club">
      <h4>会员信息</h4>
      <p class="hider">会员账号：${(member.memNum)!''}</p>
      <p class="hider">真实姓名：${(member.realName)!''}</p>
      <p class="hider">推荐人编号：${(member.tjrNum)!'无'}</p>
    </div>
    <dl class="h_data">
      <dd>
        <ul>
          <li><span class="yellow_text">激活积分：</span>&yen;${(currencyinfo.activPenn)?string(',##0.00')!'0.00'}</li>
          <li><span class="yellow_text">现金积分：</span>&yen;${(currencyinfo.crashPoints)?string(',##0.00')!'0.00'}</li>
          <li><span class="yellow_text">团队收益：</span>&yen;${(currencyinfo.teamPoints)?string(',##0.00')!'0.00'}</li>
          <li><span class="yellow_text">现金积分累计：</span>&yen;${(cashBonusTotal)?string(',##0.00')!'0.00'}</li>
          <li><span class="yellow_text">团队收益累计：</span>&yen;${(layerBonusTotal)?string(',##0.00')!'0.00'}</li>
        </ul>
      </dd>
      
      <dt>注册时间：${(member.registTime)?string("yyyy-MM-dd HH:mm:ss")!''} </dt>
      <dt>
      	激活时间：${(member.jhTime)?string("yyyy-MM-dd HH:mm:ss")!''} 
      	<font color="green">
      		(<#if member.jhState?? && member.jhState==2>已激活<#else>未激活</#if>)
      	</font>
       </dt>
        <dt>我的二维码： </dt>
        <dt><img src="${(tgRegisterPic)!''}" width="150" height="150" /></dt>
    </dl>
  </div>