# 项目开发环境(

+ JDK 1.8
+ Maven 3.5
+ Redis 5.0.7
+ Mysql 5.7.26
+ 开发中使用lombok,请注意安装lombok插件
+ 项目运行后进入http://localhost:8080/unicorn/doc.html

# Unicorn
自己做的快捷使用的单服务框架，如果方便的话后续会做成分布式以用于今后的快速开发  
项目只有后端,遇到好的前段到时候会加进去,说是这么说有点空投支票的意思,等遇到好的前段再说吧,看到项目愿意一起玩的也可以留言联系我


# 2019/8/21 开发日记 - yuyufenf
最近事情比较烦，项目开发开始填没有认真订需求，开发周期几乎没有，以及比较关键的是客户对页面设计不满意的问题。基本大部分时间都拿来填坑和应付领导了，真正
落下来做事的时间也被压缩，更不要说开发自己的项目。乘机更新一下框架，后面还会拉同事进来完善，为大家能找个好下家以及进一步的学习做好准备。
## 21：09 更新 -yuyufenf
终于把拦截器整合完了，一直身体不太舒服，晕晕乎乎的想着快点写完了睡会，最后还是没撑住睡着了，person估计后面有时间看下来都是糊烂的，等有时间了再改吧，先记下来看着
# 2019/12/30 yuyufenf
添加了些后续项目中写的需要实战使用和学习的东西,比如rides.删减修改了一部分旧的代码.今天刚出差归来,估计下班之前应该会一直对框架修修改改年尾了,也祝各位程序员们身体
健康,明年项目多赚钱还不用加班,有时间陪陪自己的家人女友(纸片人老婆也好啊).先上传一部分,下班前再上一部分
## 16:54 更新 -yuyufenf
添加了redis的依赖,之前忘了搞了.花了点时间把之前的文件存储至本地的工具类优化了一下,修改成了存储流文件和二进制文件的接口,可以允许文件名和文件类型分开传
输(为后续可能对不同文件类型处理准备)
# 2019/12/31 -yuyufenf
沉迷放假前的摸鱼无法自拔(真是欠揍呢),更新了一下用户模块,之前这块是参照9月份的项目编写的,现在看来屎一般的实用性,后面打算先从这个模块改起,再添加机构模块,
权限功能,字典模块这种比较常见模块吧.目前应该是有需要重构的项目,还是依旧先空投支票,有时间慢慢做.