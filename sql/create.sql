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

ALTER TABLE R_ENUMS_INFO ADD (KEY_BAK VARCHAR2(50));

CREATE SEQUENCE  SEQ_R_ENUMS_INFO  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 10000 CACHE 20 NOORDER  NOCYCLE;

insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (100, '1000', '电影', '0', '1000');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (101, '1001', '电视剧', '0', '1001');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (102, '1002', '纪实', '0', '1002');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (103, '1003', '体育', '0', '1003');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (104, '1004', '新闻', '0', '1004');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (105, '1005', '综艺', '0', '1005');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (106, '1006', '娱乐', '0', '1006');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (107, '1007', '动漫', '0', '1007');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (108, '1008', '生活', '0', '1008');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (109, '1009', '旅游', '0', '1009');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (110, '1010', '原创', '0', '1010');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (111, '1011', '教育', '0', '1011');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (112, '500020', '直播', '0', '500020');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (113, '500060', '悦听-有声小说', '0', '500060');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (114, '500067', '悦听-评书', '0', '500067');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (115, '500072', '悦听-电台', '0', '500072');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (116, '500078', '悦听-热点资讯', '0', '500078');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (117, '500100', '悦听-儿童', '0', '500100');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (118, '500106', '悦听-娱乐', '0', '500106');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (119, '500111', '悦听-都市白领', '0', '500111');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (120, '500213', '渠道推广', '0', '500213');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (121, '500323', '音频', '0', '500323');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (122, '500405', '军事', '0', '500405');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (123, '500468', '健康', '0', '500468');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (124, '500424', '搞笑', '0', '500424');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (125, '500377', '法制', '0', '500377');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (126, '501200', '个人电台', '0', '501200');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (127, '501207', '广播剧', '0', '501207');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (128, '501217', '曲艺', '0', '501217');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (129, '501227', '有声小说', '0', '501227');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (130, '500320', '财经', '0', '500320');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (131, '500422', '时尚', '0', '500422');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (132, '500960', 'MV', '0', '500960');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1001, '1001', '描述年代', '1', 'mediaMiaoshun');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1002, '1002', '编剧', '1', 'mediaBianju');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1003, '1003', '制式', '1', 'mediaZhishi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1004, '1004', '人物', '1', 'mediaRenwu');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1005, '1005', '场景', '1', 'mediaChangjing');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1006, '1006', '综艺秀场', '1', 'mediaXiuchang');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1007, '1007', '主持人', '1', 'mediaZhuchi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1008, '1008', '嘉宾', '1', 'mediaJiabin');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1009, '1009', '制样', '1', 'mediaZhiyang');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1010, '1010', '作者', '1', 'mediaZuozhe');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1011, '1011', '原著作者', '1', 'mediaYuanzhu');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1012, '1012', '艺术表现', '1', 'mediaYishu');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1013, '1013', '风格', '1', 'mediaFengge');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1014, '1014', '受众年龄', '1', 'mediaNianling');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1015, '1015', '诊疗科目', '1', 'mediaZhenliao');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1016, '1016', '药理分类', '1', 'mediaYaoli');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1017, '1017', '养生方式', '1', 'mediaYangsheng');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1018, '1018', '食疗', '1', 'mediaShiliao');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1019, '1019', '疾病', '1', 'mediaJibing');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1020, '1020', '两性', '1', 'mediaLiangxing');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1021, '1021', '美容', '1', 'mediaMeirong');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1022, '1022', '母婴', '1', 'mediaMuying');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1023, '1023', '赛事', '1', 'mediaSaishi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1024, '1024', '解说员', '1', 'mediaJieshuo');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1025, '1025', '明星', '1', 'mediaMingxing');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1026, '1026', '报道形式', '1', 'mediaBaodaos');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1027, '1027', '报道人物', '1', 'mediaBaodaor');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1028, '1028', '学科', '1', 'mediaXueke');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1029, '1029', '职场', '1', 'mediaZhichang');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1030, '1030', '幼教', '1', 'mediaYoujiao');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1031, '1031', '外语考试', '1', 'mediaWaiyu');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1032, '1032', '公开课', '1', 'mediaGongkai');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1033, '1033', '国考', '1', 'mediaGuokao');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1034, '1034', '考试类型', '1', 'mediaKaoshi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1035, '1035', '考研', '1', 'mediaKaoyan');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1036, '1036', '留学', '1', 'mediaLiuxue');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1037, '1037', '名师', '1', 'mediaMingshi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1038, '1038', '年级', '1', 'mediaNianji');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1039, '1039', '内容形态', '1', 'mediaShape');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1040, '1040', '方式', '1', 'mediaFangshi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1041, '1041', '景点', '1', 'mediaJingdian');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1042, '1042', '目的地', '1', 'mediaMudidi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1043, '1043', '文化', '1', 'mediaWenhua');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1044, '1044', '服饰', '1', 'mediaFushi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1045, '1045', '家居', '1', 'mediaJiaju');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1046, '1046', '丽人', '1', 'mediaLiren');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1047, '1047', '美食', '1', 'mediaMeishi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1048, '1048', '武器装备', '1', 'mediaWuqi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1049, '1049', '军事人物', '1', 'mediaJunshi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1050, '1050', '汽车', '1', 'mediaQiche');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1051, '1051', '房产', '1', 'mediaFangchan');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1052, '1052', '股市', '1', 'mediaGushi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1053, '1053', '投资理财', '1', 'mediaTouzi');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1054, '1054', '歌手姓名', '1', 'mediaGeshoux');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1055, '1055', '歌手类型', '1', 'mediaGeshoul');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1056, '1056', '表演形式', '1', 'mediaBiaoyan');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1057, '1057', '特色分类', '1', 'mediaTese');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1058, '1058', '作词', '1', 'mediaZuoci');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1059, '1059', '作曲', '1', 'mediaZuoqu');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1060, '1060', '所属专辑', '1', 'mediaSuoshu');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1061, '1061', '主播', '1', 'mediaZhubo');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1062, '1062', '篇幅', '1', 'mediaVideoPianfu');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1063, '1063', '名著名段', '1', 'mediaMingzhu');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1064, '1064', '语言', '1', 'mediaYuyan');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1065, '1065', '作者/记者', '1', 'mediaJizhe');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1066, '1066', '播出平台', '1', 'mediaPlat');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1067, '1067', '描述地区', '1', 'mediaMiaoshud');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1068, '1068', '报道地区', '1', 'mediaReportArea');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1069, '1069', '项目', '1', 'mediaProj');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1070, '1070', 'G客作品', '1', 'mediaGkzp');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1071, '1071', 'G客活动', '1', 'mediaGkhd');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1072, '1072', '首播时间', '1', 'mediaPremiereTime');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1073, '1073', '主演', '1', 'mediaActor');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1074, '1074', '所属片名', '1', 'mediaVideoName');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1075, '1075', '内容类型', '1', 'mediaType');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1076, '1076', '上映时间', '1', 'mediaTime');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1077, '1077', '电影形式', '1', 'mediaMovieForm');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1078, '1078', '导演', '1', 'mediaDirector');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1079, '1079', '播出年代', '1', 'mediaYear');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1080, '1080', '关键字', '1', 'priKeyword');
insert into R_ENUMS_INFO (ID, KEY_, VAL_, TYPE_, KEY_BAK) values (1081, '1081', '推荐标签', '1', 'contRecomm');


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
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (16, 'search.default.enable', 'true', '是否调用搜索引擎');
--20161017
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (17, 'print.request.enable', 'true', '是否大数据的日志');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (18, 'request.default.tag.cat.max', '10', '请求用户标签时一级分类的最大个数');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (19, 'request.default.tag.catitem.max', '10', '请求用户标签时一级分类下的普通标签最大个数');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (20, 'request.default.tag.recomd.max', '10', '请求用户标签时一级分类下的推荐标签最大个数');
--20161108
CREATE TABLE R_VOMS_RECOMMEND
(
    ID NUMBER NOT NULL,
    OBJ_ID NUMBER NOT NULL,
    LABEL_INFO VARCHAR2(4000),  
   	NAME_ VARCHAR2(200),
    TYPE_ CHAR(1),
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
   	CREATOR_  VARCHAR2(100),
    UPDATOR_  VARCHAR2(100),
    PRD_TYPE VARCHAR2(20), 
    IS_RECOMMEND CHAR(1)，
    PRIMARY KEY (ID),
    CONSTRAINT VOMS_RECOMMEND_PRDCONTID UNIQUE (OBJ_ID, PRD_TYPE, TYPE_)
);
CREATE SEQUENCE  SEQ_R_VOMS_RECOMMEND MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER  NOCYCLE;
--20161118
	alter table R_VOMS_RECOMMEND modify TYPE_ VARCHAR2(2);
	alter table R_VOMS_RECOMMEND add OBJ_TYPE VARCHAR2(3);
	ALTER TABLE R_VOMS_RECOMMEND DROP CONSTRAINT VOMS_RECOMMEND_PRDCONTID;
	ALTER TABLE R_VOMS_RECOMMEND add CONSTRAINT VOMS_RECOMMEND_PRDCONTID UNIQUE (OBJ_ID, PRD_TYPE, TYPE_,OBJ_TYPE);

--20161130
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (21, 'recomd.default.specialTopic.ratio', '0', '综合推荐时，专题推荐比例，只可为正小数，否则为0，如0.02');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (22, 'recomd.default.combinedCont.ratio', '0', '综合推荐时，组合内容推荐比例，只可为正小数，否则为0，如0.02');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (23, 'recomd.default.bigPicCont.ratio', '0.125', '综合推荐时，大图内容推荐比例，只可为正小数，否则为0，如0.02');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (24, 'recomd.default.multiPicCont.ratio', '0', '综合推荐时，多图内容推荐比例，只可为正小数，否则为0，如0.02');
--20161207
CREATE TABLE R_ENUMS_CONFIG
    (
        ID NUMBER(22) NOT NULL,
        KEY_ VARCHAR2(50) NOT NULL,
        TYPE_ CHAR(1) NOT NULL,
        PARENT VARCHAR2(50),
        WEIGHT VARCHAR2(50),
        PRIMARY KEY (ID)
    );
CREATE SEQUENCE  SEQ_R_ENUMS_CONFIG MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER  NOCYCLE;

insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(101,'1001','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(102,'1002','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(103,'1003','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(104,'1004','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(105,'1005','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(106,'1006','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(107,'1007','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(108,'1008','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(109,'1009','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(100,'1000','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(110,'1010','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(111,'1011','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(112,'500020','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(113,'500060','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(114,'500067','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(115,'500072','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(116,'500078','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(117,'500100','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(118,'500106','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(119,'500111','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(120,'500213','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(121,'500323','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(122,'500405','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(123,'500468','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(124,'500424','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(125,'500377','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(126,'501200','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(127,'501207','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(128,'501217','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(129,'501227','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(130,'500320','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(131,'500422','0',null,'100.00');
insert into R_ENUMS_CONFIG (ID,KEY_,TYPE_,PARENT,WEIGHT) values(132,'500960','0',null,'100.00');

--20161205
CREATE TABLE R_TOP_RECOMMEND
(
    ID NUMBER NOT NULL,
    TOP_ID NUMBER NOT NULL,
    PRD_TYPE VARCHAR2(20),
    TOP_NAME VARCHAR2(200),
    STATUS_ NUMBER,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATOR_  VARCHAR2(100),
    UPDATOR_  VARCHAR2(100),
    PRIMARY KEY (ID),
    CONSTRAINT TOP_RECOMMEND_PRDCONTID UNIQUE (TOP_ID,PRD_TYPE)
);
CREATE SEQUENCE  SEQ_R_TOP_RECOMMEND MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER  NOCYCLE;
--20161228
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (25, 'recomd.default.tag.cat.weight', '50', '推荐时，一级标签默认权重');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (26, 'recomd.default.tag.item.weight', '50', '推荐时，普通标签默认权重');
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (27, 'recomd.default.tag.rcmditem.weight', '50', '推荐时，推荐标签默认权重');

--20170324
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (28, 'search.default.with.weight', 'false', '调用搜索引擎时，是否带权重搜索');

delete from R_SYSTEM_CONFIG where CONFIG_KEY = 'search.default.limit.catItem';
delete from R_SYSTEM_CONFIG where CONFIG_KEY = 'search.default.cat.per.max';
delete from R_SYSTEM_CONFIG where CONFIG_KEY = 'search.recomd.enable';
delete from R_SYSTEM_CONFIG where CONFIG_KEY = 'search.default.count.max';

ALTER TABLE R_ENUMS_INFO RENAME COLUMN KEY_BAK TO KEY_DESC;

--20170407
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (29, 'search.default.soTimeout', '3000', '调用搜索引擎时，请求数据返回超时时间，单位 ms，重启生效');
--20170410
insert into R_SYSTEM_CONFIG (ID, CONFIG_KEY, CONFIG_VALUE, DETAIL_) values (30, 'search.default.searchagain.afterfail', 'false', '调用搜索引擎时，如果搜索失败，是否再试一次');
