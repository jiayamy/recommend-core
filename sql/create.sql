--20160930
CREATE TABLE R_ENUMS_INFO
(
    ID NUMBER NOT NULL,
    KEY_ VARCHAR2(50),
    VAL_ VARCHAR2(50),
    TYPE_ CHAR(1),
    PRIMARY KEY (ID),
    CONSTRAINT IDX_ENUMS_KEY UNIQUE (TYPE_, KEY_),
    CONSTRAINT IDX_ENUMS_VAL UNIQUE (TYPE_, VAL_)
);
CREATE SEQUENCE  SEQ_R_ENUMS_INFO  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 10000 CACHE 20 NOORDER  NOCYCLE;

insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (100, '1000', '电影', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (101, '1001', '电视剧', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (102, '1002', '纪实', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (103, '1003', '体育', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (104, '1004', '新闻', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (105, '1005', '综艺', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (106, '1006', '娱乐', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (107, '1007', '动漫', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (108, '1008', '生活', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (109, '1009', '旅游', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (110, '1010', '原创', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (111, '1011', '教育', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (112, '500020', '直播', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (113, '500060', '悦听-有声小说', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (114, '500067', '悦听-评书', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (115, '500072', '悦听-电台', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (116, '500078', '悦听-热点资讯', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (117, '500100', '悦听-儿童', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (118, '500106', '悦听-娱乐', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (119, '500111', '悦听-都市白领', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (120, '500213', '渠道推广', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (121, '500323', '音频', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (122, '500405', '军事', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (123, '500468', '健康', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (124, '500424', '搞笑', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (125, '500377', '法制', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (126, '501200', '个人电台', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (127, '501207', '广播剧', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (128, '501217', '曲艺', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (129, '501227', '有声小说', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (130, '500320', '财经', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (131, '500422', '时尚', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (132, '500960', 'MV', '0');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1001, 'mediaMiaoshun', '描述年代', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1002, 'mediaBianju', '编剧', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1003, 'mediaZhishi', '制式', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1004, 'mediaRenwu', '人物', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1005, 'mediaChangjing', '场景', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1006, 'mediaXiuchang', '综艺秀场', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1007, 'mediaZhuchi', '主持人', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1008, 'mediaJiabin', '嘉宾', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1009, 'mediaZhiyang', '制样', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1010, 'mediaZuozhe', '作者', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1011, 'mediaYuanzhu', '原著作者', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1012, 'mediaYishu', '艺术表现', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1013, 'mediaFengge', '风格', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1014, 'mediaNianling', '受众年龄', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1015, 'mediaZhenliao', '诊疗科目', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1016, 'mediaYaoli', '药理分类', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1017, 'mediaYangsheng', '养生方式', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1018, 'mediaShiliao', '食疗', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1019, 'mediaJibing', '疾病', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1020, 'mediaLiangxing', '两性', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1021, 'mediaMeirong', '美容', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1022, 'mediaMuying', '母婴', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1023, 'mediaSaishi', '赛事', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1024, 'mediaJieshuo', '解说员', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1025, 'mediaMingxing', '明星', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1026, 'mediaBaodaos', '报道形式', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1027, 'mediaBaodaor', '报道人物', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1028, 'mediaXueke', '学科', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1029, 'mediaZhichang', '职场', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1030, 'mediaYoujiao', '幼教', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1031, 'mediaWaiyu', '外语考试', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1032, 'mediaGongkai', '公开课', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1033, 'mediaGuokao', '国考', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1034, 'mediaKaoshi', '考试类型', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1035, 'mediaKaoyan', '考研', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1036, 'mediaLiuxue', '留学', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1037, 'mediaMingshi', '名师', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1038, 'mediaNianji', '年级', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1039, 'mediaShape', '内容形态', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1040, 'mediaFangshi', '方式', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1041, 'mediaJingdian', '景点', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1042, 'mediaMudidi', '目的地', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1043, 'mediaWenhua', '文化', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1044, 'mediaFushi', '服饰', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1045, 'mediaJiaju', '家居', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1046, 'mediaLiren', '丽人', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1047, 'mediaMeishi', '美食', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1048, 'mediaWuqi', '武器装备', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1049, 'mediaJunshi', '军事人物', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1050, 'mediaQiche', '汽车', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1051, 'mediaFangchan', '房产', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1052, 'mediaGushi', '股市', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1053, 'mediaTouzi', '投资理财', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1054, 'mediaGeshoux', '歌手姓名', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1055, 'mediaGeshoul', '歌手类型', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1056, 'mediaBiaoyan', '表演形式', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1057, 'mediaTese', '特色分类', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1058, 'mediaZuoci', '作词', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1059, 'mediaZuoqu', '作曲', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1060, 'mediaSuoshu', '所属专辑', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1061, 'mediaZhubo', '主播', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1062, 'mediaVideoPianfu', '篇幅', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1063, 'mediaMingzhu', '名著名段', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1064, 'mediaYuyan', '语言', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1065, 'mediaJizhe', '作者/记者', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1066, 'mediaPlat', '播出平台', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1067, 'mediaMiaoshud', '描述地区', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1068, 'mediaReportArea', '报道地区', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1069, 'mediaProj', '项目', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1070, 'mediaGkzp', 'G客作品', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1071, 'mediaGkhd', 'G客活动', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1072, 'mediaPremiereTime', '首播时间', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1073, 'mediaActor', '主演', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1074, 'mediaVideoName', '所属片名', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1075, 'mediaType', '内容类型', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1076, 'mediaTime', '上映时间', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1077, 'mediaMovieForm', '电影形式', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1078, 'mediaDirector', '导演', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1079, 'mediaYear', '播出年代', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1080, 'priKeyword', '关键字', '1');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_) values (1081, 'contRecomm', '推荐标签', '1');

CREATE TABLE R_INFO
(
    ID NUMBER NOT NULL,
    LABEL_INFO VARCHAR2(4000),
    PRD_CONTID NUMBER,
    CONT_NAME VARCHAR2(200),
    STATUS_ NUMBER,
    CREATE_TIME DATE,
    CREATOR_ VARCHAR2(100),
    UPDATE_TIME DATE,
    UPDATOR_ VARCHAR2(100),
    PRD_TYPE VARCHAR2(20),
    CAT_ID VARCHAR2(50),
    PRIMARY KEY (ID),
    CONSTRAINT IDX_INFO_PRDCONTID UNIQUE (CAT_ID, PRD_TYPE, PRD_CONTID)
);
CREATE SEQUENCE  SEQ_R_INFO  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER  NOCYCLE;

CREATE TABLE R_PRDTYPE_RELATION
(
    ID NUMBER NOT NULL,
    PRD_TYPE VARCHAR2(20),
    PRD_INFO_IDS VARCHAR2(2000),
    PRD_NAME VARCHAR2(100),
    SEARCH_CT VARCHAR2(20),
    PRIMARY KEY (ID),
    CONSTRAINT IDX_PRDTYPER_TYPE UNIQUE (PRD_TYPE)
);
CREATE SEQUENCE  SEQ_R_PRDTYPE_RELATION  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER  NOCYCLE;

insert into R_PRDTYPE_RELATION (ID, PRD_TYPE, PRD_INFO_IDS, PRD_NAME, SEARCH_CT) values (1, 'MIGUSHIPIN', '1002101,1002102,1002103,1002601,1002581,1002381,1002261', '咪咕视频', '501');
insert into R_PRDTYPE_RELATION (ID, PRD_TYPE, PRD_INFO_IDS, PRD_NAME, SEARCH_CT) values (2, 'MIGUYINGYUAN', '1002821', '咪咕影院', '502');


CREATE TABLE R_SYSTEM_CONFIG
(
    ID NUMBER NOT NULL,
    CONFIG_KEY VARCHAR2(200),
    CONFIG_VALUE VARCHAR2(4000),
    DETAIL_ VARCHAR2(4000),
    PRIMARY KEY (ID),
    CONSTRAINT IDX_SYSCONFIG_KEY UNIQUE (CONFIG_KEY)
);
CREATE SEQUENCE  SEQ_R_SYSTEM_CONFIG  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER  NOCYCLE;

insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (1, 'user.tag.default', '{}', '用户默认标签');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (2, 'user.tag.score.default', '10', '用户标签默认分数');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (3, 'search.url', 'http://221.181.100.37:8082/search/opensearch.msp', '搜索请求地址');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (4, 'search.default.limit', '20', '调用搜索引擎时，查询一次一级分类最多查询多少条记录');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (5, 'search.default.limit.catItem', '5', '调用搜索引擎时，查询一次一级分类下的固定标签最多查询多少条记录');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (6, 'search.default.count.max', '100', '正常调用请求最多查询多少条记录进行分页');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (7, 'search.default.cat.max', '3', '调用搜索引擎时，最多查询多少个一级分类');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (8, 'search.default.catitem.max', '2', '调用搜索引擎时，最多查询多少个一级分类下的标签');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (9, 'search.default.recomditem.max', '5', '默认最多搜索多少个推荐标签');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (10, 'request.default.limit', '10', '请求默认每页条数');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (12, 'search.recomd.enable', 'true', '搜索时，带推荐标签');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (14, 'recomd.default.cat.max', '5', '人工推荐时，最多查询多少个一级分类');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (15, 'recomd.default.catitem.max', '10', '人工推荐时，最多查询多少个一级分类下推荐标签');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (16, 'search.default.enable', 'false', '是否调用搜索引擎');


