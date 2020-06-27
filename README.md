# bookstore

## 数据库配置

```mysql
CREATE TABLE `user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `status` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
```

```mysql
CREATE TABLE `deal` (
  `uid` int(4) NOT NULL,
  `bookName` varchar(20) NOT NULL,
  `picture` text,
  `description` varchar(200) DEFAULT NULL,
  `status` int(4) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`,`bookName`,`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8

```

## 项目说明
还有一些细小功能没有实现，但碍于马上考试。先搁置在这里
分页功能（写过servlet版本）

~~注册功能（简单）~~

~~图片上传（好好研究下）~~

上传功能完成，在个人中心的展示也没有问题，但是出现了这样的问题：首页图片展示不了，因为首页的表格是需要
异步请求数据库展示，Ajax返回的数据拼接图片路径时，不能请求到springboot配置的虚拟路径映射，如果使用绝对地址
又会拒绝访问。考完试了研究研究这个问题


多添加几组好看的数据做测试

顺便可以练习以下项目的版本更迭

~~如果出现错误甚至还可以学习版本的回溯。~~


### 啰里啰唆
这个项目是这么回事：

我springMVC出了点问题，怎么都请求不到Controller，我改了两天没找到原因，甚至重新构建了几遍都失败了

深刻的让我体会到了繁杂的配置，

但是马上要投简历了，还有课设，考试很多事情

最后我决定用springboot来做课设，之前学过，但步骤忘了好多，就一边看视频，一遍搭项目，

本来想着这是个测试项目，没想到越写越大，功能实现都很顺利，起码没有遇到解决不了的配置问题，然后基本完成了课设所需的功能

我就干脆把这个项目先放到GitHub上，也算是一个springboot的小项目

考试逃不过，溜了溜了
再不投这个简历我担心要错过了，我还是想试一下提前批的，字节那个电商的部门很吸引我，我这两天都无法集中注意力到学校的复习上，一直想完善这个项目然后投简历

本来想发布到远程主机，但中间遇到了数据库连接问题，解决了一个小时没有解决成功，后天考试，考完试解决。
