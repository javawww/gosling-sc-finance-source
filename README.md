# gosling-sc-finance-source
投资管理项目，采用太阳线+小公排制度，项目分会员平台+管理后台，采用主流SSM技术开发，开源代码，供学习研究。

# 采用MAVEN多模块构建
>* gosling-sc-finance-parent父模块
>* gosling-base-core 核心模块：工具类，异常类，异步封装类
>* gosling-base-dao 数据库交互：CURD
>* gosling-sc-finance-controller 控制器+业务逻辑

# 依赖关系
>* gosling-sc-finance-controller  <--- gosling-base-dao
>* gosling-sc-finance-controller  <--- ggosling-base-core
