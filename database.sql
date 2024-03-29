USE [bookStore]
GO
/****** Object:  User [bookstore]    Script Date: 06/25/2018 09:05:38 ******/
CREATE USER [bookstore] FOR LOGIN [bookstore] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[userid]    Script Date: 06/25/2018 09:05:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[userid](
	[logname] [varchar](16) NOT NULL,
	[realname] [varchar](10) NULL,
	[passwd] [varchar](50) NOT NULL,
	[email] [varchar](20) NOT NULL,
	[gender] [varchar](2) NOT NULL,
	[uaddress] [varchar](100) NULL,
	[phone] [char](11) NOT NULL,
	[problem] [varchar](40) NULL,
	[answer] [varchar](40) NULL,
	[province] [varchar](20) NULL,
	[education] [varchar](10) NULL,
	[hobbies] [varchar](100) NULL,
	[selfintro] [varchar](100) NULL,
	[utype] [char](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[logname] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[userid] ([logname], [realname], [passwd], [email], [gender], [uaddress], [phone], [problem], [answer], [province], [education], [hobbies], [selfintro], [utype]) VALUES (N'admin', N'李四', N'password', N'1234567@qq.com', N'男', N'广东科技学院', N'12345678912', N'答案是什么？', N'', N'广东省', N'本科', N'打代码', N'我是管理员', N'2')
INSERT [dbo].[userid] ([logname], [realname], [passwd], [email], [gender], [uaddress], [phone], [problem], [answer], [province], [education], [hobbies], [selfintro], [utype]) VALUES (N'lisi', N'李四', N'password', N'12345@qq.com', N'男', N'广东科技学院', N'12345678911', N'问题？', N'答案', N'广东省', N'本科', N'打代码', N'我不是管理员', N'2')
INSERT [dbo].[userid] ([logname], [realname], [passwd], [email], [gender], [uaddress], [phone], [problem], [answer], [province], [education], [hobbies], [selfintro], [utype]) VALUES (N'logname', N'李四', N'123456', N'1223456@qq.com', N'男', N'地址', N'12345678930', N'问题', N'答案', N'广东省', N'高中', N'打球', N'我是用户', N'1')
INSERT [dbo].[userid] ([logname], [realname], [passwd], [email], [gender], [uaddress], [phone], [problem], [answer], [province], [education], [hobbies], [selfintro], [utype]) VALUES (N'阿萨德', N'阿萨德', N'asdf', N'阿斯蒂@qq.com', N'男', N'asdfsadf', N'12345678994', N'asdf', N'asdf', N'asdf', N'asdf', N'asdf', N'asdf', N'1')
INSERT [dbo].[userid] ([logname], [realname], [passwd], [email], [gender], [uaddress], [phone], [problem], [answer], [province], [education], [hobbies], [selfintro], [utype]) VALUES (N'王五', N'王五', N'123456', N'654321@qq.com', N'男', N'广东科技学院', N'65432132110', N'我是谁？', N'王五', N'广东省', N'本科', N'不告诉你', N'懒得写', N'1')
INSERT [dbo].[userid] ([logname], [realname], [passwd], [email], [gender], [uaddress], [phone], [problem], [answer], [province], [education], [hobbies], [selfintro], [utype]) VALUES (N'张三', N'张三', N'123456', N'123456@qq.com', N'男', N'地址', N'12345678910', N'问题', N'', N'广东省', N'本科', N'打码', N'程序员', N'1')
INSERT [dbo].[userid] ([logname], [realname], [passwd], [email], [gender], [uaddress], [phone], [problem], [answer], [province], [education], [hobbies], [selfintro], [utype]) VALUES (N'猪肉荣', N'陈五', N'987654', N'123321421@qq.com', N'男', N'广东科技学院', N'65432165431', N'我是男的女的？', N'', N'广东省', N'本科', N'卖猪肉', N'我在雅苑菜市场卖猪肉，我为自己带盐！！！', N'1')
/****** Object:  Table [dbo].[orders]    Script Date: 06/25/2018 09:05:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[orders](
	[Oid] [int] NOT NULL,
	[user_names] [varchar](16) NULL,
	[goods_names] [varchar](100) NULL,
	[goods_count] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Oid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[orders] ([Oid], [user_names], [goods_names], [goods_count]) VALUES (1, N'张三', N'精通数据科学 从线性回归到深度学习', 1)
INSERT [dbo].[orders] ([Oid], [user_names], [goods_names], [goods_count]) VALUES (3, N'admin', N'数据库原理及应用（第2版）', 1)
INSERT [dbo].[orders] ([Oid], [user_names], [goods_names], [goods_count]) VALUES (4, N'张三', N'JAVA语言程序设计（第二版）', 1)
/****** Object:  Table [dbo].[booktype]    Script Date: 06/25/2018 09:05:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[booktype](
	[typename] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[typename] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[booktype] ([typename]) VALUES (N'化学')
INSERT [dbo].[booktype] ([typename]) VALUES (N'计算机')
INSERT [dbo].[booktype] ([typename]) VALUES (N'教育')
INSERT [dbo].[booktype] ([typename]) VALUES (N'历史')
INSERT [dbo].[booktype] ([typename]) VALUES (N'其他')
INSERT [dbo].[booktype] ([typename]) VALUES (N'社科科学')
INSERT [dbo].[booktype] ([typename]) VALUES (N'思政')
INSERT [dbo].[booktype] ([typename]) VALUES (N'通识')
INSERT [dbo].[booktype] ([typename]) VALUES (N'文学')
INSERT [dbo].[booktype] ([typename]) VALUES (N'物理')
INSERT [dbo].[booktype] ([typename]) VALUES (N'心理')
INSERT [dbo].[booktype] ([typename]) VALUES (N'医学')
INSERT [dbo].[booktype] ([typename]) VALUES (N'语言')
INSERT [dbo].[booktype] ([typename]) VALUES (N'自然科学')
/****** Object:  Table [dbo].[book]    Script Date: 06/25/2018 09:05:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[book](
	[id] [varchar](10) NOT NULL,
	[bname] [varchar](100) NULL,
	[btype] [varchar](20) NULL,
	[autho] [varchar](40) NULL,
	[press] [varchar](50) NULL,
	[price] [float] NOT NULL,
	[repertory] [int] NOT NULL,
	[times] [date] NULL,
	[intro] [varchar](2000) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000000', N'JAVA语言程序设计（第二版）', N'计算机', N'丁振凡', N'清华大学出版社', 40, 2994, CAST(0x563E0B00 AS Date), N'这是一本由丁振凡主导编写的，由清华大学出版社出版的JAVA语言程序设计基础教程用书 ')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000002', N'数据库原理及应用（第2版）', N'计算机', N'何玉洁', N'人民邮电出版社', 35, 2999, CAST(0x563E0B00 AS Date), N'本书主要内容包括关系数据库基础、SQL语言、关系数据理论、数据库设计、事务与并发控制、后台数据库编程、视图和索引、安全管理、备份和恢复数据库等。
本书条理清晰、语言简洁、适合作为高等院校计算机及理工科类多用计算机学科的大学本科数据库教材，也可作为相关人员学习数据库知识的参考书。')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000003', N'精通数据科学 从线性回归到深度学习', N'计算机', N'唐亘', N'人民邮电出版社', 82.5, 2998, CAST(0x573E0B00 AS Date), N'数据科学入门到实战 基于Python建模 详解从统计分析学到人工智能机器学习 深度学习 神经网络编程中用到的算法及模型')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000004', N' 可伸缩服务架构：框架与中间件', N'计算机', N'李艳鹏 等', N'电子工业出版社', 100, 5000, CAST(0x573E0B00 AS Date), N'随机发售作者亲笔签名版，技术大咖热赞！详解分布式发号器、消息队列框架、数据库分库分表、缓存、ES、分布式调度任务、RPC、Dubbo、高性能中间件，破解可伸缩服务架构奥秘')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000005', N'Python神经网络编程', N'计算机', N'Tariq Rashid', N'人民邮电出版社', 57.5, 5000, CAST(0x573E0B00 AS Date), N'人工智能深度学习机器学习领域又一重磅力作 自己动手用Python编写神经网络 美亚排名前茅荣获众多好评 全彩印刷 图表丰富')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000006', N'区块链 人工智能 数字货币：黑科技让生活更美好？', N'计算机', N'Adam Greenfield', N'电子工业出版社', 69.4000015258789, 4995, CAST(0x573E0B00 AS Date), N'《纽约时报》 美国亚马逊畅销书；解密正在全面爆发的区块链、人工智能和数字货币等黑科技，跟紧未来趋势，用技术重构世界；独特的表现手法，科幻大片般的既视感，你一定爱读的黑科技之书')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000007', N'以太坊技术详解与实战', N'计算机', N'闫莺 郑凯 郭众鑫', N'机械工业出版社', 41.299999237060547, 1000, CAST(0x573E0B00 AS Date), N'Vitalik Buterin倾力推荐！深入了解以太坊架构、关键技术、智能合约编写，以及性能、安全等必要内容')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000008', N'Effective Modern C++中文版', N'化学', N'Scott Meyers', N'中国电力出版社', 74.300003051757812, 998, CAST(0x573E0B00 AS Date), N'想要彻底理解C 11和C 14，不可止步于熟悉它们引入的语言特性（例如，auto型别推导、移动语义、lambda表达式，以及并发支持）。挑战在于高效地运用这些特性，从而使你的软件具备正确性、高效率、可维护性和可移植性。这正是本书意欲达成的定位。它描述的正是使用C 11和C 14（即现代C ）来编写真正卓越的软件之道。涵盖以下主题：大括号初始化、noexcept规格、完美转发，以及智能指针的make函数的优缺点。std::move、std::forward、右值引用和*引用之间的联系。编写整洁、正确，以及高效的lambda表达式的方法。std::atomic和volatile有怎样的区别，它们分别用于什么场合，以及它们和C 的并发API有何联系。“旧”C 程序设计（即C 98）中的实战要求在现代C 的软件开发中作出哪些修订。')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000009', N'数据库原理及应用（第2版）', N'计算机', N'何玉洁', N'人民邮电出版社', 35, 2999, CAST(0x573E0B00 AS Date), N'本书使用几种不同的软件来创建室内设计演示板，高效传达设计理念。
将Adobe Photoshop、 Autodesk AutoCAD、 Trimble SketchUp、 Adobe InDesign和手绘图形综合在一起组合图形完成演示板，是当前设计界非常有价值的一种工作方法。这种方法能够帮助设计师优化图形，创建出专业、精美的项目作品。本书正是教你怎么利用这种手法来更好展示你的室内设计作品。虽然本书的重点是使用Photoshop优化3D模型，但同时还展示了SketchUp的使用方法，以及使用InDesign组装演示板的方法，每款软件各具特色和功能，综合使用这些软件，才能以*快速、*效的方式创作出*精美的作品。')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000010', N'CCF中学生计算机程序设计套装（共2册）', N'计算机', N'中国计算机学会', N'中国科技出版传媒股份有限公司', 58.400001525878906, 3000, CAST(0x573E0B00 AS Date), N'本丛书是基于《CCF青少年计算机程序设计评级标准》开发的一个系列培训教材。该标准围绕计算机程序设计的知识要求和能力要求，共分十级，其中1-3级为基础级，4-5级为提高级，6-7级为高手级，8-10级为大师级。本丛书将评级内容进行归纳，计划1-3级出1本、4-5级出1本，6-7级出1本，8-10级出1本，共4本教材。')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000011', N'C Primer Plus（第五版）中文版(经久不衰的经典教程，C语言入门的不二之选)', N'化学', N'Stephen Prata', N'人民邮电出版社', 47.200000762939453, 5000, CAST(0x573E0B00 AS Date), N'《C Primer Plus（第5版）（中文版）》共17章。第1、2章学习C语言编程所需的预备知识。第3到15章介绍了C语言的相关知识，包括数据类型、格式化输入输出、运算符、表达式、流程控制语句、函数、数组和指针、字符串操作、内存管理、位操作等等，知识内容都针对C99标准；另外，第10章强化了对指针的讨论，第12章引入了动态内存分配的概念，这些内容更加适合读者的需求。第16章和第17章讨论了C预处理器和C库函数、高级数据表示（数据结构）方面的内容。附录给出了各章后面复习题、编程练习的答案和丰富的C编程参考资料。')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000012', N' 编程珠玑（第2版·修订版）', N'计算机', N'Jon Bentley', N'人民邮电出版社', 30.799999237060547, 5000, CAST(0x573E0B00 AS Date), N'本书是计算机科学方面的经典名著。书的内容围绕程序设计人员面对的一系列实际问题展开。作者Jon Bentley 以其独有的洞察力和创造力，引导读者理解这些问题并学会解决方法，而这些正是程序员实际编程生涯中至关重要的。本书的特色是通过一些精心设计的有趣而又颇具指导意义的程序，对实用程序设计技巧及基本设计原则进行了透彻而睿智的描述，为复杂的编程问题提供了清晰而完备的解决思路。本书对各个层次的程序员都具有很高的阅读价值。')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000013', N'送你一颗子弹', N'文学', N'刘瑜', N'东方出版中心', 29.600000381469727, 5000, CAST(0x573E0B00 AS Date), N'在这本书新修订的书里，除了被“审视”的东西杂七杂八，有街上的疯老头，有同宿舍的室友，有爱情、电影和书，大到制度，小到老鼠。由于我写这些东西的时候，出发点并不是写一本书，所以不同文章往往风格迥异，长短不一，质量不均，随着社会形势、荷尔蒙周期以及我逃避生活的力度而起伏。同时增加多篇新的内容和篇章，读来令人拍案叫绝！')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000014', N'唐诗三百首详析 (简体本)', N'文学', N'喻守真', N'中华书局', 22.899999618530273, 10000, CAST(0x573E0B00 AS Date), N'本书是《唐诗三百首》的注释本，初版于1948年，书中对诗人生平事迹和创作特点等均有简要介绍，注释简明浅显，不作过多征引和考证，着重于揭示诗的主题，剖析作者的艺术构思、结构章法、创作特点等，有助于读者鉴赏。')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000015', N'鲁迅全集（全20卷，纪念鲁迅先生逝世80周年！）', N'文学', N'鲁迅', N'北京日报出版社（原同心出版社）', 299, 10000, CAST(0x573E0B00 AS Date), N'1936年10月，鲁迅先生在上海逝世。鲁迅先生纪念委员会为"扩大鲁迅精神的影响，以唤醒国魂，争取光明"编印了鲁迅逝后第一版《鲁迅全集》。
　　《全集》由蔡元培任主席的鲁迅先生纪念委员会负责编校，编辑委员有蔡元培、马裕藻、沈兼士、茅盾、周作人诸先生。《全集》总目以鲁迅亲定的著述目录为基础，增加了译作部分，并力求各册字数大致相当。全书大致分创作、古籍校辑、译作三大部分。各部分内容按时间先后排序。全书总计六百余万字，共分二十卷。于1938年6月正式出版并发行。
　　本次出版，就是以1938年的这一版《鲁迅全集》作为底本的。在编辑过程中，尽可能的保留原版的风貌。
　　全书内容和编排体例均与原版相同。按原版编排，共分20卷。其中创作、古籍校辑、译作三大部分依然按照时间先后排序。仅根据*关于写作时间的考证，调整了个别内容的顺序。
　　全书文字校订，只是将繁体竖排转为简体横排，仅改正了原版中个别错字和标点。其中通假字和鲁迅习惯用字，完全按照原版保留。另有外国人名、地名等，均保留鲁迅当时的译法')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000016', N'莎士比亚戏剧全集（朱生豪经典全译本，收入莎翁所有10部悲剧和13部喜剧）', N'化学', N'威廉·莎士比亚 ', N'作家出版社', 127.5, 5000, CAST(0x573E0B00 AS Date), N'  “上帝梦见了世界，就像莎士比亚梦见了他的戏剧。他创造了近千年来文学*重要的作品，被认为是‘俗世的圣经’。”（博尔赫斯语）其中莎士比亚的悲剧涉及社会生活的各个方面：有以爱情为题材的悲剧，以复仇为线索的悲剧，还有直接揭露“野心”“金钱”“权势”等罪恶的悲剧。其中喜剧在莎士比亚戏剧创作中占有相当分量，本书四册共收入了莎翁所有的10部悲剧和13部喜剧作品。机智风趣的语言将浪漫、抒情、讽刺的风格发挥得淋漓尽致，戏谑当中渗透着些许悲剧意味，更显其喜。这些作品是历经时间打磨、被永世传颂的厚重之作。“
')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000017', N'厚积落叶听雨声', N'文学', N'朱光潜 ', N'江苏文艺出版社', 37.200000762939453, 3000, CAST(0x573E0B00 AS Date), N'《厚积落叶听雨声》是美学大师朱光潜首部经典作品精编，收录《谈美》《谈修养》《给青年的十二封信》中家喻户晓的篇目，选编了《生命》《慈慧殿三号》《后门大街》等经典散文佳作，更特别精选了近60幅东西方艺术名作，精美图文，全彩装帧，解读大师毕生思想精华。
   在这个叫嚣扰攘的世界里，我们需要的不是一盆八宝饭，而是一贴清凉散。经历过不美的岁月，置一个聆听的位置，听内心的声音，让自己醒来。真正的美极为柔弱，却不可征服。')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000018', N'丁立梅经典散文集（全三册）', N'文学', N'丁立梅', N'东方出版社', 78.0999984741211, 8000, CAST(0x573E0B00 AS Date), N'丁立梅经典散文精选集（套装三册）共精选了丁立梅150多篇经典散文作品。让读者在这个繁忙浮躁的世界，体会刻骨铭心的柔软！ 书中殷建坤进行导读，从大语文入手详细分析丁立梅散文的思想内容、语言运用、写作技巧，把作家创作过程中感性的思维过程，用理性的分析呈现出来，给中学生的阅读和写作提供具体可感的有效的借鉴。')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000019', N'自由的夜行', N'文学', N'史铁生', N'百花洲文艺出版社', 35.5, 7000, CAST(0x573E0B00 AS Date), N'活没活好并没有一个外在标准，而只能由自己来认定它是否“有意义”。生命迟早会向人索要意义，当那一天到来，你会怎样回答生命的拷问？
　　生命分为两种，一种是有限的身在，一种是无限的行魂。我们又该为自己短暂的一生寻求什么样的意义呢？
　　这本书收录了史铁生先生散文30篇，它不仅是一本书，还是一份礼物，是孤独者的良药，亦是彷徨者的信心。
　　命运并不受贿，唯信心者能受其恩典。而信心，既不需要事先的许诺，也就不必有事后的恭维，它的恩惠唯在渡涉苦难的时候可以领受。')
INSERT [dbo].[book] ([id], [bname], [btype], [autho], [press], [price], [repertory], [times], [intro]) VALUES (N'0000000020', N'张爱玲全集06：流言（2012年全新修订版)', N'文学', N'张爱玲', N'北京十月文艺出版社', 28.399999618530273, 5000, CAST(0x573E0B00 AS Date), N'《流言》收录《私语》《烬余录》等颇具张爱玲自传性的散文，《童言无忌》《姑姑语录》《公寓生活记趣》等有助于了解张爱玲家人、生活的散文，以及《自己的文章》《关于倾城之恋的老实话》等能更好地理解张爱玲创作的文章等；并首次收录*发现的散佚作品《炎樱衣谱》《寄读者》。')
/****** Object:  Check [CK__orders__goods_co__7D439ABD]    Script Date: 06/25/2018 09:05:38 ******/
ALTER TABLE [dbo].[orders]  WITH CHECK ADD CHECK  (([goods_count]>=(0)))
GO
/****** Object:  Check [CK__userid__gender__619B8048]    Script Date: 06/25/2018 09:05:38 ******/
ALTER TABLE [dbo].[userid]  WITH CHECK ADD CHECK  (([gender]='男' OR [gender]='女'))
GO
