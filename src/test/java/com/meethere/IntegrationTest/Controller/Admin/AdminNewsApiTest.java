package com.meethere.IntegrationTest.Controller.Admin;

import com.meethere.MeetHereApplication;
import com.meethere.entity.News;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MeetHereApplication.class)
@AutoConfigureMockMvc
@Transactional
public class AdminNewsApiTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void IT_TD_013_001_001_001() throws Exception{
        ResultActions perform=mockMvc.perform(get("/news_manage"));
        perform.andExpect(status().isOk()).andDo(print());
        MvcResult mvcResult=mockMvc.perform(get("/news_manage")).andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        assertModelAttributeAvailable(mv,"total");
    }

    @Test
    public void IT_TD_013_003_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(get("/news_edit").param("newsID","16"));
        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        perform.andExpect(status().isOk()).andDo(print());
        assertModelAttributeAvailable(mv,"news");
    }
    @Test
    public void IT_TD_013_003_001_002() throws Exception {
        assertThrows(NestedServletException.class,()->mockMvc.perform(get("/news_edit").param("newsID","250")),"newsID不存在！");
    }
    @Test
    public void IT_TD_013_004_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(get("/newsList.do").param("page","1"));
        perform.andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void IT_TD_013_007_001_001() throws Exception {
        ResultActions perform=mockMvc.perform(post("/delNews.do").param("newsID","16"));
        perform.andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void IT_TD_013_007_001_002() throws Exception {
        assertThrows(NestedServletException.class,()->mockMvc.perform(post("/delNews.do").param("newsID","250")),"newsID不存在！");
    }

    @Test
    public void IT_TD_013_006_001_001() throws Exception {
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addNews.do").param("title","").param("content","content"))
        );
    }
    @Test
    public void IT_TD_013_006_001_002() throws Exception {
        ResultActions perform=mockMvc.perform(post("/addNews.do").param("title","title").
                param("content","content"));
        perform.andExpect(redirectedUrl("news_manage")).andDo(print());
    }
    @Test
    public void IT_TD_013_006_001_003() throws Exception {
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addNews.do").param("title","秋膏减列匪县颠打编奏窜粮督浸闪缎惜鸭浓露盏抗狡鉴步削辅逢思恨愁签轰感乙皮摸卜穿阴锡尿因惨检沃乳孤稠船查它诊玻砍格迁峡二赶盟挑惩岩互选功炕宫微珠题估京蔬寒罢芦液撒假商鸦又邀历孙敞衣造硬舍澡动湿叹肥卡非锯门").param("content","content"))
        );
    }
    @Test
    public void IT_TD_013_006_001_004() throws Exception {
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addNews.do").param("title","title").param("content",""))
        );
    }
    @Test
    public void IT_TD_013_006_001_005() throws Exception {
        assertThrows(NestedServletException.class,
                ()->mockMvc.perform(post("/addNews.do").param("title","title").param("content","适鸭由歪面涉铺秆兼动学嫁卜宗暖稻概舅胜鹅蛾冒稳薯偶蒜立周谅广冶月谈运熄架强纲胆建迅守疆夹顶店耽置咬党宿唉邻应绑虚便萝绪需信嚼搅衣刀盼浴楼倾障庭屿挎系桥塌对临掘跌病闻洲剧关容久桂蚕鱼膝单喷豪蛙遭费裂爆袋网威姥偷宇漏滚拾仆克织巷东饶漫喇恶李丝流田般追徐心梢蛛祝于晌担奋刃烂衡朋勉外葱致技抓错耳吴茎迫壤南巨饿品站陷港算幻瘦递无苦细匠忽倍黎出铸墨树善额达趋撇第碌划放茶独菌姜卧皂匆乳殿盐膀旋剖躺栗钞登惨熊获饱纽跳申闭曾器苏猫剩微伤腐益催桐切疲纠啊骆赌怨纺代都柜腿解签蝴缴毫投骗孟较捆雅村脖尺腹挤贴榆蹦勾抛节译野尖瓶伐世盒披驴穴充寨嫩弓装按秤转扯抖途姻境黑籍袍枯裁牢急招堂轧竿镜荐叠遍肝酸框沟逃牵塞局陶责哭皇狂吗总誓增印杰御堤赖俩痕晃补泥规博弃言搭瞧仁蓝欧煎捏绝采棕诚维重帮箩请杀里竟冈狭跨牲库孩汽屋蝶继数其订严凑少兆漆杏虫乌货除钻烧乞择安侦腾勇低午捐精仙浇示借励丹术屠闷凤岂遇芳徒搬过伴住锤躲生薄艇戚偿搞谱婶荒抹妨征杆加察烈检众耕乘游化脏撤貌鸽税拢写硬泉粮控讨蜡饼轨古裙省魔鬼捕酒聋协袄览忌牺洁肤和桃碰齿吹疼摇醒凭托航窝武奏芹帝炼子奇兵效太揪萄圈卷鸟屑年二衰宙打袭挣旱秩贿者析势管谊三贼唯直絮彼俭埋盟偏门稍录窃予陪阶中滨受乔畏仓帽甩脚趟执傲师捡痰雹拔论杂疯青乖日弦柿诱凶尾官翁惹氧妄攀几仇衔训度插农饰摄侵逼财宽用捉复恼响分亏爬耐恰餐州潮手辨颗套替号塘虏猜命鸣真陕枝拍角舰亮乎质今厅倦府趁位陆哪毁含群股糕吼隆怠传焦促乱拜累梳密辆摆消穷露四完软腥冠遣形惠米踩舱折淡西刘唇蓬味绳利糟富夫院留带到寄喘肚辰环贵宵例绘演盏乃拼犹死依早您敢恐穗舍础专食求耍辱拥戴叫产损了潜居谜妖惯怪星僚醉热翠愁榴宅罩粪他裹添它很拉身艰乡述汇抢旗晓拴淋歼墙廊乐悄冷秘姿禽阴鼓集军挡答怒欣敲嚷魂苗佩帆缩倚擦竞眼斑车晨喜暗狼绩谎舒亚董输婚垒升奸储盘绸兔挑粘老邪覆茧朽渔葛许饲伞慨蛇叶督步泽曲柔镇脑扛冬告逐敬会丢笼咽浩桌判砌咳条讯艺允遵纷君扫菊阻臭型哥捎搂粱凳浓萍九揭经刊避尿拐级播瞎厘倘拦全免筑狸姑壶妥呢卸释固戒够供思派垂且筛摩清胁恒涨迹嗓厦政暂的坐拨睛渠如鼻纳更废罪伸樱争通浮贷奖蜓像疾筹炎亭件庆甘舞劲牧驶甲访劈张载泳属疤忠炒囊挠巡常贫胶销宝款疗研咱治续白船乒肠绍联回是间医哨遮污搁决叙倡仗金测值翻馋改杨楚忧驳个链附五可高随懒奉盛混趴滔一后连茫龙阔悦胳将天功佣业挖华永串作视孕葬宣机快援破痛裳毯馅帖炮并幸塔来下雄劫寿猎钢棉比牌夸抱旺口仿坏道嘉轮泛炭棒拳茂私份搜摸社导咸粥券哑县浊飘爽晋凝滋爸报熔父题悬看领峡邀祸权矛劳飞槐却家润撒虹让矮冲朵骄吃慕驱团近勿迟礼燃诉吞驼缘售宋刚颠竭岭恋班盗玉蛋普雀芦悲约砍扑贝被共任石照委摘甜所入梦针珠咐趣妈脆畅赵剂滑阅栋碍映饥夜忆狮交仪堆落昌斜羞客津激去贡坦裕饭雾芬底堡设笋叹灌犁虎叮匙拖屯付塑捷德渣剪结突构赴傅皆最然扰痒伙压扭伪窄蔑巧七表歌询湾燥做残兴僻友香鉴努逮罗斯束往秒挨类只昼幼琴警犯风彻王舟统柱蚂夕才练排制蜻怎畜声走喂谷减音悠马引又扒培叉纸妹想慎红部块稀昏帜而民绿晶暑淘辽批习力赠锯肯丧锹敏缎基跪斥弄碑乓躁枣备愿跃估胀桶族稠忘纤儿脱场母异闪篇浙绢迈喊吩险踢誉桑还怀秃撞役贤山配句缓陈非害赛刮巾雨钩为寇膨俊掀盆次蚁慢斧知俘就贸务赤足胸柏毛积洪词抗锅祥栽缝惩寒策智围范岔见息她赢止缠捞垦诗窜仔阵胞膛龄肺滴跟新惑狡肿语问希幅恳霉聚肥惰膏匪蒸澡截汪睬至铁简区洽洋教左顺锡始吧离先界进爹该明须持扔罢献逆恩距滩射鸦副某隔帅尚拆尤苹索海此林顾灶蹄蔬弱丽薪刺迎贪席刑笑毙贺斗性名银档理零轿哄钳哲殊整据适鸭由歪面涉铺秆兼动学嫁卜宗暖稻概舅胜鹅蛾冒稳薯偶蒜立周谅广冶月谈运熄架强纲胆建迅守疆夹顶店耽置咬党宿唉邻应绑虚便萝绪需信嚼搅衣刀盼浴楼倾障庭屿挎系桥塌对临掘跌病闻洲剧关容久桂蚕鱼膝单喷豪蛙遭费裂爆袋网威姥偷宇漏滚拾仆克织巷东饶漫喇恶李丝流田般追徐心梢蛛祝于晌担奋刃烂衡朋勉外葱致技抓错耳吴茎迫壤南巨饿品站陷港算幻瘦递无苦细匠忽倍黎出铸墨树善额达趋撇第碌划放茶独菌姜卧皂匆乳殿盐膀旋剖躺栗钞登惨熊获饱纽跳申闭曾器苏猫剩微伤腐益催桐切疲纠啊骆赌怨纺代都柜腿解签蝴缴毫投骗孟较捆雅村脖尺腹挤贴榆蹦勾抛节译野尖瓶伐世盒披驴穴充寨嫩弓装按秤转扯抖途姻境黑籍袍枯裁牢急招堂轧竿镜荐叠遍肝酸框沟逃牵塞局陶责哭皇狂吗总誓增印杰御堤赖俩痕晃补泥规博弃言搭瞧仁蓝欧煎捏绝采棕诚维重帮箩请杀里竟冈狭跨牲库孩汽屋蝶继数其订严凑少兆漆杏虫乌货除钻烧乞择安侦腾勇低午捐精仙浇示借励丹术屠闷凤岂遇芳徒搬过伴住锤躲生薄艇戚偿搞谱婶荒抹妨征杆加察烈检众耕乘游化脏撤貌鸽税拢写硬泉粮控讨蜡饼轨古裙省魔鬼捕酒聋协袄览忌牺洁肤和桃碰齿吹疼摇醒凭托航窝武奏芹帝炼子奇兵效太揪萄圈卷鸟屑年二衰宙打袭挣旱秩贿者析势管谊三贼唯直絮彼俭埋盟偏门稍录窃予陪阶中滨受乔畏仓帽甩脚趟执傲师捡痰雹拔论杂疯青乖日弦柿诱凶尾官翁惹氧妄攀几仇衔训度插农饰摄侵逼财宽用捉复恼响分亏爬耐恰餐州潮手辨颗套替号塘虏猜命鸣真陕枝拍角舰亮乎质今厅倦府趁位陆哪毁含群股糕吼隆怠传焦促乱拜累梳密辆摆消穷露四完软腥冠遣形惠米踩舱折淡西刘唇蓬味绳利糟富夫院留带到寄喘肚辰环贵宵例绘演盏乃拼犹死依早您敢恐穗舍础专食求耍辱拥戴叫产损了潜居谜妖惯怪星僚醉热翠愁榴宅罩粪他裹添它很拉身艰乡述汇抢旗晓拴淋歼墙廊乐悄冷秘姿禽阴鼓集军挡答怒欣敲嚷魂苗佩帆缩倚擦竞眼斑车晨喜暗狼绩谎舒亚董输婚垒升奸储盘绸兔挑粘老邪覆茧朽渔葛许饲伞慨蛇叶督步泽曲柔镇脑扛冬告逐敬会丢笼咽浩桌判砌咳条讯艺允遵纷君扫菊阻臭型哥捎搂粱凳浓萍九揭经刊避尿拐级播瞎厘倘拦全免筑狸姑壶妥呢卸释固戒够供思派垂且筛摩清胁恒涨迹嗓厦政暂的坐拨睛渠如鼻纳更废罪伸樱争通浮贷奖蜓像疾筹炎亭件庆甘舞劲牧驶甲访劈张载泳属疤忠炒囊挠巡常贫胶销宝款疗研咱治续白船乒肠绍联回是间医哨遮污搁决叙倡仗金测值翻馋改杨楚忧驳个链附五可高随懒奉盛混趴滔一后连茫龙阔悦胳将天功佣业挖华永串作视孕葬宣机快援破痛裳毯馅帖炮并幸塔来下雄劫寿猎钢棉比牌夸抱旺口仿坏道嘉轮泛炭棒拳茂私份搜摸社导咸粥券哑县浊飘爽晋凝滋爸报熔父题悬看领峡邀祸权矛劳飞槐却家润撒虹让矮冲朵骄吃慕驱团近勿迟礼燃诉吞驼缘售宋刚颠竭岭恋班盗玉蛋普雀芦悲约砍扑贝被共任石照委摘甜所入梦针珠咐趣妈脆畅赵剂滑阅栋碍映饥夜忆狮交仪堆落昌斜羞客津激去贡坦裕饭雾芬底堡设笋叹灌犁虎叮匙拖屯付塑捷德渣剪结突构赴傅皆最然扰痒伙压扭伪窄蔑巧七表歌询湾燥做残兴僻友香鉴努逮罗斯束往秒挨类只昼幼琴警犯风彻王舟统柱蚂夕才练排制蜻怎畜声走喂谷减音悠马引又扒培叉纸妹想慎红部块稀昏帜而民绿晶暑淘辽批习力赠锯肯丧锹敏缎基跪斥弄碑乓躁枣备愿跃估胀桶族稠忘纤儿脱场母异闪篇浙绢迈喊吩险踢誉桑还怀秃撞役贤山配句缓陈非害赛刮巾雨钩为寇膨俊掀盆次蚁慢斧知俘就贸务赤足胸柏毛积洪词抗锅祥栽缝惩寒策智围范岔见息她赢止缠捞垦诗窜仔阵胞膛龄肺滴跟新惑狡肿语问希幅恳霉聚肥惰膏匪蒸澡截汪睬至铁简区洽洋教左顺锡始吧离先界进爹该明须持扔罢献逆恩距滩射鸦副某隔帅尚拆尤苹索海此林顾灶蹄蔬弱丽薪刺迎贪席刑笑毙贺斗性名银档理零轿哄钳哲殊整据蚀掏买颂镰袜哀晕肌草茅淹健油史渴驻之辣嘴你愤尘蕉序垄卖谨逝狗箱键湖侍疏丑磨涛猛耗女胖肃摧详志辈勤呆陡态厂蜘承何狱珍喉壮段双上杯握们伏记掉堪从庸拌宪颤矩丘企蛮盈爪锻郎娃龟扮柳况璃沉挪涂唐袖叛云辜队迁危候哈孔尊情料收患阁铜状践兽膊愈国望同尼崇颈戏赏汉脉济路杜逢攻假保慰踪台婆伶骤员鲁占享洒摊蠢崖展拘丁欠轻骨听饮腰果定锁螺夺腊座烦闹认延江紧阳但那脂找叨圆圾律雁泪碗劣庄则八营忍鄙有易疮朴姐俗沈纯当羽呀厉翼俱极剥颜奴呈辅兄劝番宾冻届浪议吸葵调震处沙掌科址似欲宏板泡瞒耻程溪萌地仰旷秋难内困臂吐胃锈期棋六授使伯沃魄返梁桨筝否吊铲焰钓成湿既抵余钥波挺骡酷森雪背与姨顷烟校好坝召梨弊棵退发遗验散笨必垮历驾浅窑磁介击怜渡鹿也肾修半侨贞探端朱起伍存电仍姓岁奶园鞋舌熟梯呼酿陵刷椒械宁岩不嗽霸童堵苍筋模末窗炸降兰式疑春祖臣弟误深图啦捧项泊艘匀谋断创孙植冤泄撕蜜阀职帘顽棍梅郑妙咏预体大感株歉诊考证脸章绞菠盲嘱蜂彩旅万眠抄特片初竹粒你喝瓣停主茄丸轰谢色选旁我殖恢奥斤翅烘相涌秧坑注丙计藏荡浸漂鼠猾封爷药扩络渗夏时莲支衫物傍纪豆闲查租弹揉慌蓄称携每虾版朝量粉庙现略康骂违辞蝇市实膜郊烫榜讽虽神染尝盾满光麦朗标吵笛页晚繁旬赞牙自殃闸说缸蔽橡灭寺画融意隙抬禾净烛罚乏酱推购霞亦列弯法把坟醋铃佳滥井池宴绣液源脊气掩点旧狠煤等踏优悔钱恨操蹲麻短葡肢紫坛辉花火反酬钉钟合毒办壳眯核娱摔渐橘两已识己素伟辛泼启扬皱猪令码床限巴疫贯迷远碧霜暴洗尽各防向行黄象侧岗芽灯隶战本商吉押若洞多终荣玩韵廉观莫馒割妻组跑惜唱饺鲜佛粗扶倒崭篮怕丛削剑宰溉吨抚垫试敞男嫂尸岸即义呜赔括边诞样册盖京锋径瓦欺愚鞭元均撑差际荷描没布暮因厌宫互诵公沿虑举拿季悉念垃隐氏辟事僵毅卫炕雕户芝话层溜炊蒙铅静晴屈赚贩原锄筒革寸恭辫亲谦厨亿木秀狐厚换率艳峰傻确接巩谁默课瓜肉触要影究邮裤胡觉悟什司百赶毕送悼坊血平资犬睁晒爱文讲仅得糊松躬笔以愉哗待城棚慧侄着肩眨灿汗归牛猴指诸绕岛宜矿超方沸助振纱债正腔聪掠筐俯锦长扇帐监线鸡壁挽景昂娇糖馆灰旦典头椅砖罐欢旨工案逗卵斩良编种干遥人齐美亡养著阿包辩厕前这浑柴卡币能亩侮符负休坡循枕横驰活稿骑具书惭蹈失另圣士碎叼糠盯惊昨街脾顿或纵吓灵惧奔靠杠惕唤匹扁禁透泻寻读河炉拒凉穿价幕愧变水提拣汁开孝剃扎删鞠症勺挂室北凡柄根缺坚千滤鹰右施屡耀土丈小雷些抽丰育败漠冰绒沾取么昆在瑞故灾衬怖凯首孤稼材煮川慈啄闯忙服护鹊纹乙再栏及羡福贱玻肆显浆勒造竖准汤泰菜未越填墓箭燕扣票救芒枪域歇参房锣挥睡球目温榨沫字甚烤皮格搏谣十槽英速懂评叔妇空煌蚊嫌给别锐绵涝刻央羊移敌娘眉审蚀掏买颂镰袜哀晕肌草茅淹健油史渴驻之辣嘴愤尘蕉序垄卖谨逝狗箱键湖侍疏丑磨涛猛耗女胖肃摧详志辈勤呆陡态厂蜘承何狱珍喉壮段双上杯握们伏记掉堪从庸拌宪颤矩丘企蛮盈爪锻郎娃龟扮柳况璃沉挪涂唐袖叛云辜队迁危候哈孔尊情料收患阁铜状践兽膊愈国望同尼崇颈戏赏汉脉济路杜逢攻假保慰踪台婆伶骤员鲁占享洒摊蠢崖展拘丁欠轻骨听饮腰果定锁螺夺腊座烦闹认延江紧阳但那脂找叨圆圾律雁泪碗劣庄则八营忍鄙有易疮朴姐俗沈纯当羽呀厉翼俱极剥颜奴呈辅兄劝番宾冻届浪议吸葵调震处沙掌科址似欲宏板泡瞒耻程溪萌地仰旷秋难内困臂吐胃锈期棋六授使伯沃魄返梁桨筝否吊铲焰钓成湿既抵余钥波挺骡酷森雪背与姨顷烟校好坝召梨弊棵退发遗验散笨必垮历驾浅窑磁介击怜渡鹿也肾修半侨贞探端朱起伍存电仍姓岁奶园鞋舌熟梯呼酿陵刷椒械宁岩不嗽霸童堵苍筋模末窗炸降兰式疑春祖臣弟误深图啦捧项泊艘匀谋断创孙植冤泄撕蜜阀职帘顽棍梅郑妙咏预体大感株歉诊考证脸章绞菠盲嘱蜂彩旅万眠抄特片初竹粒你喝瓣停主茄丸轰谢色选旁我殖恢奥斤翅烘相涌秧坑注丙计藏荡浸漂鼠猾封爷药扩络渗夏时莲支衫物傍纪豆闲查租弹揉慌蓄称携每虾版朝量粉庙现略康骂违辞蝇市实膜郊烫榜讽虽神染尝盾满光麦朗标吵笛页晚繁旬赞牙自殃闸说缸蔽橡灭寺画融意隙抬禾净烛罚乏酱推购霞亦列弯法把坟醋铃佳滥井池宴绣液源脊气掩点旧狠煤等踏优悔钱恨操蹲麻短葡肢紫坛辉花火反酬钉钟合毒办壳眯核娱摔渐橘两已识己素伟辛泼启扬皱猪令码床限巴疫贯迷远碧霜暴洗尽各防向行黄象侧岗芽灯隶战本商吉押若洞多终荣玩韵廉观莫馒割妻组跑惜唱饺鲜佛粗扶倒崭篮怕丛削剑宰溉吨抚垫试敞男嫂尸岸即义呜赔括边诞样册盖京锋径瓦欺愚鞭元均撑差际荷描没布暮因厌宫互诵公沿虑举拿季悉念垃隐氏辟事僵毅卫炕雕户芝话层溜炊蒙铅静晴屈赚贩原锄筒革寸恭辫亲谦厨亿木秀狐厚换率艳峰傻确接巩谁默课瓜肉触要影究邮裤胡觉悟什司百赶毕送悼坊血平资犬睁晒爱文讲仅得糊松躬笔以愉哗待城棚慧侄着肩眨灿汗归牛猴指诸绕岛宜矿超方沸助振纱债正腔聪掠筐俯锦长扇帐监线鸡壁挽景昂娇糖馆灰旦典头椅砖罐欢旨工案逗卵斩良编种干遥人齐美亡养著阿包辩厕前这浑柴卡币能亩侮符负休坡循枕横驰活稿骑具书惭蹈失另圣士碎叼糠盯惊昨街脾顿或纵吓灵惧奔靠杠惕唤匹扁禁透泻寻读河炉拒凉穿价幕愧变水提拣汁开孝剃扎删鞠症勺挂室北凡柄根缺坚千滤鹰右施屡耀土丈小雷些抽丰育败漠冰绒沾取么昆在瑞故灾衬怖凯首孤稼材煮川慈啄闯忙服护鹊纹乙再栏及羡福贱玻肆显浆勒造竖准汤泰菜未越填墓箭燕扣票救芒枪域歇参房锣挥睡球目温榨沫字甚烤皮格搏谣十槽英速懂评叔妇空煌蚊嫌给别锐绵涝刻央羊移敌娘眉审"))
        );
    }
}
