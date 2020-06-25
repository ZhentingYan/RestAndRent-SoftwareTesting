package com.meethere.IntegrationTest.Service;

import com.meethere.MeetHereApplication;
import com.meethere.entity.News;
import com.meethere.service.impl.NewsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MeetHereApplication.class)
@Transactional
public class NewsServiceTest {
    @Autowired
    private NewsServiceImpl newsService;

    @Test
    public void IT_TD_003_001_001_001() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<News> res = newsService.findAll(pageable);
        assertEquals(1, res.getTotalPages());
    }

    @Test
    public void IT_TD_003_002_001_001() {
        int id = 1;
        String title = "";
        String content = "券蒙韵幼但女哑镇烟裙应仰落陷懒寸鲁白绘杆臭墓叮罩眼袋冤网坟亲蒜蚂避弟撇典叨颈旗躲一五袭耕予亏揉权立燕追题锈止平渗接禽搂填暑顽晴开辆丑鼓剃铺震易锐首疑妹笨概鄙社及桶爆武柱炭顾叶财款页睡蹈拦蔬负贡俯插虹拢老亡漠幅贤迷邮熊赢宋拴三膜呼塌驰乳紫抄半侦览国保残孝勒执笼甚仓拨旧尼阁想耍惹剩歪是值金期约翠奴博坛夹叠四同毯忌崖缴蚀井腥挺户勇尸恢祖霸渣握片吞沾伟么定慧凡糠支侄墙基贞喂劲疯汽搏罢险弓仍妨且冷发夺伯击悉朵确已圆饥说夜姨逝强夕猪塘踢送膨切扭筝统序睁拾嫂桃耀旋翻毁馋匠窃宽狡暂泊铲垒站娘凉趁盆太和航洽田付挖钱律摊牵测缎烈芦释纠隶轧碌七朗邻姜征知弄妻叛饼雨阳貌浴守嚼潜此捆带宅泛悲滴躁丸颜免也该翅岗煌屈像叉购贷笑缓艇顷巩抢粱干荣刚伸今涉讲孩宇溪脚渠削组己脖咽朝虚头炒云僵晋怎毙梅透乏赖戚江雀冠医番域个双连肩悟起卷焰朋携司欠低破炮哪兄恨秩槽钞钳屯娃幕慰掘筋望悼彻梦只疼羊币洞壶秀恭著路屑钻粒侨巧这采醋别翼宵棉眯信进俊絮玻扎才探边辨蛋佛樱钓菊榜虏漫沟脱躺肃王腿作岭扛哨川撤秘芽笋好扔岁碍译肉居厌疮乓窑愧共微庙又薄凶鸟整瓦虎址务忽画般慌北犬债节轻日隔待懂光郑浆积贸袖搜郎经异狐则茧挂宗耐显难粘逗肚聪葡床棋贯古企巨粪石青足称逆促畅械演毛蜻孔传析纵休煮贴竹改每引害滨脉承幻操轨跟央神蓝星证蛛库口吩跳得蜜略替动竖隙涂柄讯随昆炉霜近怨预杨帖芒活敏诗搞细场拆俘某镜拘恐两延时裤峡楚封宰忘言驴块位其浩伶张卸准道热谨由听斥代拒现罚写甩做身示管书数原野膏施表灭晒祸峰斩庸跌魄辫薪蛾考鉴惭轰生享扣趣陶尽授据淋就超堆挑矮晃迅师受衔羡血兴谣脾旺诵苗养手狱祥谜铁盘变果赶步锯昼看挥议内爷旬剑米项技环至刑君育象拼射慕掏把驶删话既爪违季箭徒办绩架性淘灿餐外它袜哄摇辛泡讨劫啦迫联扶完胆瘦聋爸零讽湖辱颤闸惕疫例斯串舍塑丰册铸靠队英充姿如麦末陕源移弱秒正痒维忧亭愤锡衰肺喝趴铃红涌未萄各策年麻琴样敌啄众屡鹊煤堡薯贫肌谢验竭盟驼寇撒六俩盾情降宫惯葵廉意藏蝴揭糊标宙秋更电贵林扩式役岩饱八馅敞图剧槐莲映厚乔村兔会棕启膊碎智当决无速织暗京夫久并商用戒爬暮扯隐爽荐凑拖烤仅敢兵礼官蜡盈倍窜沿鬼啊船旦埋厘帘百较摄她临窄娱雹错告具扫幸瞎退胳夸裂桌短豆距述稠销纹工宾倡泄文诉搭蚊瞒部籍录寒骆献坡废备掌舞花贼视初鸭仔读收理冬泳露寺人兆坏皱逢挣兼污谎腾磁倘痛婚粉怀留狮瓶昂回罪检燥佳茎衡帜灶舟盲继弃房丁鱼地浑巷取族浙牛隆抓申描累骨跑沸乱洁最舱究男质段输哀敬绕咳课密仿觉缠骄提慨鸡怒染产艳股夏彼冒纯斜影鼻溉俱吹踏垦嗓抛恰者捐练实畏规虽限眠酱偏火眨鼠鸣掩笛辉量饭歇柔扑解党指逃防垄香拍富董永适迈疲侧怪抚暴汇耽仇凝算鞋浸伞少计茫旅绳擦益了旷喷绣怠阻肠丘熟笔科蚕勺蔽惩浓锦炸偶滑民盛偿弦抹蠢婆牧满蛇妥席贿制额减振都托审侍阴愿割训浇牢论烧滋岸甲试祝浊儿胞轮包绿何葛递袍入再奇供嘱木遵踩糟脑迟盖斗稍扮按胡互周后陡研宴珠访妄菜毫繁伙败栗然颗渔毅货亩水尊触胖膝婶忍齐橘尤陪筒淡草奥骗展剂哈缝枪效钢蓬舰与棚咏若照傍钩吊燃登衣柿摸蛙吐固西滥桐龟软拔蹄浅境中雄阀化磨沉重黑稻腹帐树选循牺团比岔侵攀茶抗任冶借梯妈绵酿诱棍播印使贺兰润贪泽竞劈午费种凤山攻拥秆专奋池痕慢络唤怖波柳版味璃兽误够必持常腊属逮子肝熄寄批荡刀晕吨巴资领点仪饶坐赵犹碧筐窗魔黄剖箱清春梁哲恒评度粗尚排范滤秤棵姑察乡佩殖锤将或斤总长穗斑唯壤覆迎圣坦刮革键拐折修车朽小筑均响挠机候欣扰涛烦沙伴榆龙誉姓突亮背右纳撕顺附号泻丽诞凳烂皆调助奶布疤伪学困假法皇允狠事酒昌鹰锣座唐谊认尝湾编瑞令善徐丈线卧鹿猎闪捉摘驾你乞杯泰催素良践料押园相孙悠惜谦羞混税蜂伐垫寿戴势闲绒几氧故前芳元链脂堪悬膛史能简垮旱转台涨全盏新欧模板大津离楼茄劝母租姥造历独丝肯价灯倚挪鞭荷静胃角抽驻服喊纱监职圈闭向松来裁赔界淹烫世给倾抬打行傅捧玩帆锻酸伍缺塞纲铅要箩羽栋颠疏扁睛死植匆黎漂宣纸忙鲜第畜骂举奖盒壳蔑虾私踪叫分耗念赛愈绍丢倒宪命骡裳召漏撞请奏闹须章查河砌公走桥唱却豪列顶桨塔缸类躬殿况紧奉腐赤冲盯仆厕赚九滚乃仁症辈摆嘉澡傻悄蛮病配匪之恼罐食闻院饮郊培裹耻摩拣疾趟球成戏协碑友志妖蕉帝蹲妙关空千屋那舅卜需罗上有深孤娇格让悔棒沈灌很厅毕龄酷搁蓄蒸马肢臣含赴游眉直柏酬绢榴浮谁复核差端歼穷流舒恋见励竿朱围惨衬惊远枕谷根护桂狭许杜橡瞧遍瓜侮洪蝇蝶悦陆灾牲嘴于僻猫锄储色客温壮纺优赠卡德加因帽业返驱犁通秧泥在患局救府可他仗屿欲柜丹叔锁篮寻争惑亚赌吓虫十禾逼息佣似筛姐砖殊什闯叼挨恳液问截菌阶融莫姻咱凭狂炕室肆锋丧厂载凯螺欺投杠丛帅秃际斧胀力辽掉迹吉喘班哭妇堤答坝傲绸挽银到仙慈皂径飘艺猴没荒齿朴咬晚嫁杏硬体状舌纤嗽捡补穴另萝雕咐续功劣晶警缘尿昏遇撑万压镰肿希导猛晌挎横努潮套拿洲即喇竟宜尖苹以区辣蹦士特卖饺雪方忆扒刃铜形桑稀狸构崭括茅家判呈阵辞甜遣怜军牌土嫩介间下胶闷呜忠皮愁诚雁勉票盼阅系摔详乖栽群刻担品摧屠顿诊吵乘泼岛极筹吼唉穿择跃轿曲器装李二还遗父弯报推参谅孕誓净冻唇瓣归农陵安旨杀馒饿披砍赞牙捏汗克感城邀拌匀员匙景翁依捎卫去刘醒爱健浪熔萍寨恩心等名层散交余歉惰廊叹运绞旁愚损溜针睬岂吗码坊缩华叙营煎宁甘义辅逐严占奔矛过扇教株我危份僚滩挤为玉次您签市痰副坚葬词创勿档州美珍猾尘谱霉疆条捕售灵渴捷达邪鸦纽暖骤椒驳出尾集便战委面俗非渡滔控洗枝容抵亿谋稿订醉吃援芹饰反喜哗估语始哥添获默慎臂洋雅苏纪锅先港南蚁材芬雾早些耳济断店脸钟件拳捞茂垃程卵框孟洒物庆宏督帮垂海沫宝堂颂消态被疗童饲绪虑窝掠划遮所油治升门抱而住月栏遥枯巡肾明符烛杂冈馆呆渐吸怕趋康索沃型招稼鞠彩结魂不激梳否堵的致真普湿换厨钉声求壁俭设辰泉碰勤炼迁狗届合建盗阿急飞丙弹矩厉坑赏汤晨处吧记毒主贩葱掀途霞放乒快庭狼剪刷汪糕匹着肥脆乙嫌案糖从苍歌衫倦稳漆涝艰胸绝跨阔厦猜级咸左劳剥失询爹观县芝鸽终盐胜拜呢跪鹅惠伏炎腰雷氏蜘束恶校气停单吴泪陈率辜焦脊勾越呀粮往障风梢对句目增骑注森存灰曾弊敲街晓搅刺肤粥拉威杰刊苦汉置责膀本找枣墨字政柴辩碗福乌高脏梨纷精揪贱袄广派惧亦绑底诸识禁自囊术御汁乎思钥聚天础冰偷榨嚷犯里音庄宿烘矿菠抖炊胁挡扬裕昨欢愉们圾买除腔喉蜓巾省乐药搬尺奸习伤多艘辟东殃遭篇利崇贝萌锹谈椅";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        int res = newsService.create(news);
        assertTrue(res > 0);
    }

    @Test
    public void IT_TD_003_002_001_002() {
        int id = 1;
        String title = "测试五个字";
        String content = "券蒙韵幼但女哑镇烟裙应仰落陷懒寸鲁白绘杆臭墓叮罩眼袋冤网坟亲蒜蚂避弟撇典叨颈旗躲一五袭耕予亏揉权立燕追题锈止平渗接禽搂填暑顽晴开辆丑鼓剃铺震易锐首疑妹笨概鄙社及桶爆武柱炭顾叶财款页睡蹈拦蔬负贡俯插虹拢老亡漠幅贤迷邮熊赢宋拴三膜呼塌驰乳紫抄半侦览国保残孝勒执笼甚仓拨旧尼阁想耍惹剩歪是值金期约翠奴博坛夹叠四同毯忌崖缴蚀井腥挺户勇尸恢祖霸渣握片吞沾伟么定慧凡糠支侄墙基贞喂劲疯汽搏罢险弓仍妨且冷发夺伯击悉朵确已圆饥说夜姨逝强夕猪塘踢送膨切扭筝统序睁拾嫂桃耀旋翻毁馋匠窃宽狡暂泊铲垒站娘凉趁盆太和航洽田付挖钱律摊牵测缎烈芦释纠隶轧碌七朗邻姜征知弄妻叛饼雨阳貌浴守嚼潜此捆带宅泛悲滴躁丸颜免也该翅岗煌屈像叉购贷笑缓艇顷巩抢粱干荣刚伸今涉讲孩宇溪脚渠削组己脖咽朝虚头炒云僵晋怎毙梅透乏赖戚江雀冠医番域个双连肩悟起卷焰朋携司欠低破炮哪兄恨秩槽钞钳屯娃幕慰掘筋望悼彻梦只疼羊币洞壶秀恭著路屑钻粒侨巧这采醋别翼宵棉眯信进俊絮玻扎才探边辨蛋佛樱钓菊榜虏漫沟脱躺肃王腿作岭扛哨川撤秘芽笋好扔岁碍译肉居厌疮乓窑愧共微庙又薄凶鸟整瓦虎址务忽画般慌北犬债节轻日隔待懂光郑浆积贸袖搜郎经异狐则茧挂宗耐显难粘逗肚聪葡床棋贯古企巨粪石青足称逆促畅械演毛蜻孔传析纵休煮贴竹改每引害滨脉承幻操轨跟央神蓝星证蛛库口吩跳得蜜略替动竖隙涂柄讯随昆炉霜近怨预杨帖芒活敏诗搞细场拆俘某镜拘恐两延时裤峡楚封宰忘言驴块位其浩伶张卸准道热谨由听斥代拒现罚写甩做身示管书数原野膏施表灭晒祸峰斩庸跌魄辫薪蛾考鉴惭轰生享扣趣陶尽授据淋就超堆挑矮晃迅师受衔羡血兴谣脾旺诵苗养手狱祥谜铁盘变果赶步锯昼看挥议内爷旬剑米项技环至刑君育象拼射慕掏把驶删话既爪违季箭徒办绩架性淘灿餐外它袜哄摇辛泡讨劫啦迫联扶完胆瘦聋爸零讽湖辱颤闸惕疫例斯串舍塑丰册铸靠队英充姿如麦末陕源移弱秒正痒维忧亭愤锡衰肺喝趴铃红涌未萄各策年麻琴样敌啄众屡鹊煤堡薯贫肌谢验竭盟驼寇撒六俩盾情降宫惯葵廉意藏蝴揭糊标宙秋更电贵林扩式役岩饱八馅敞图剧槐莲映厚乔村兔会棕启膊碎智当决无速织暗京夫久并商用戒爬暮扯隐爽荐凑拖烤仅敢兵礼官蜡盈倍窜沿鬼啊船旦埋厘帘百较摄她临窄娱雹错告具扫幸瞎退胳夸裂桌短豆距述稠销纹工宾倡泄文诉搭蚊瞒部籍录寒骆献坡废备掌舞花贼视初鸭仔读收理冬泳露寺人兆坏皱逢挣兼污谎腾磁倘痛婚粉怀留狮瓶昂回罪检燥佳茎衡帜灶舟盲继弃房丁鱼地浑巷取族浙牛隆抓申描累骨跑沸乱洁最舱究男质段输哀敬绕咳课密仿觉缠骄提慨鸡怒染产艳股夏彼冒纯斜影鼻溉俱吹踏垦嗓抛恰者捐练实畏规虽限眠酱偏火眨鼠鸣掩笛辉量饭歇柔扑解党指逃防垄香拍富董永适迈疲侧怪抚暴汇耽仇凝算鞋浸伞少计茫旅绳擦益了旷喷绣怠阻肠丘熟笔科蚕勺蔽惩浓锦炸偶滑民盛偿弦抹蠢婆牧满蛇妥席贿制额减振都托审侍阴愿割训浇牢论烧滋岸甲试祝浊儿胞轮包绿何葛递袍入再奇供嘱木遵踩糟脑迟盖斗稍扮按胡互周后陡研宴珠访妄菜毫繁伙败栗然颗渔毅货亩水尊触胖膝婶忍齐橘尤陪筒淡草奥骗展剂哈缝枪效钢蓬舰与棚咏若照傍钩吊燃登衣柿摸蛙吐固西滥桐龟软拔蹄浅境中雄阀化磨沉重黑稻腹帐树选循牺团比岔侵攀茶抗任冶借梯妈绵酿诱棍播印使贺兰润贪泽竞劈午费种凤山攻拥秆专奋池痕慢络唤怖波柳版味璃兽误够必持常腊属逮子肝熄寄批荡刀晕吨巴资领点仪饶坐赵犹碧筐窗魔黄剖箱清春梁哲恒评度粗尚排范滤秤棵姑察乡佩殖锤将或斤总长穗斑唯壤覆迎圣坦刮革键拐折修车朽小筑均响挠机候欣扰涛烦沙伴榆龙誉姓突亮背右纳撕顺附号泻丽诞凳烂皆调助奶布疤伪学困假法皇允狠事酒昌鹰锣座唐谊认尝湾编瑞令善徐丈线卧鹿猎闪捉摘驾你乞杯泰催素良践料押园相孙悠惜谦羞混税蜂伐垫寿戴势闲绒几氧故前芳元链脂堪悬膛史能简垮旱转台涨全盏新欧模板大津离楼茄劝母租姥造历独丝肯价灯倚挪鞭荷静胃角抽驻服喊纱监职圈闭向松来裁赔界淹烫世给倾抬打行傅捧玩帆锻酸伍缺塞纲铅要箩羽栋颠疏扁睛死植匆黎漂宣纸忙鲜第畜骂举奖盒壳蔑虾私踪叫分耗念赛愈绍丢倒宪命骡裳召漏撞请奏闹须章查河砌公走桥唱却豪列顶桨塔缸类躬殿况紧奉腐赤冲盯仆厕赚九滚乃仁症辈摆嘉澡傻悄蛮病配匪之恼罐食闻院饮郊培裹耻摩拣疾趟球成戏协碑友志妖蕉帝蹲妙关空千屋那舅卜需罗上有深孤娇格让悔棒沈灌很厅毕龄酷搁蓄蒸马肢臣含赴游眉直柏酬绢榴浮谁复核差端歼穷流舒恋见励竿朱围惨衬惊远枕谷根护桂狭许杜橡瞧遍瓜侮洪蝇蝶悦陆灾牲嘴于僻猫锄储色客温壮纺优赠卡德加因帽业返驱犁通秧泥在患局救府可他仗屿欲柜丹叔锁篮寻争惑亚赌吓虫十禾逼息佣似筛姐砖殊什闯叼挨恳液问截菌阶融莫姻咱凭狂炕室肆锋丧厂载凯螺欺投杠丛帅秃际斧胀力辽掉迹吉喘班哭妇堤答坝傲绸挽银到仙慈皂径飘艺猴没荒齿朴咬晚嫁杏硬体状舌纤嗽捡补穴另萝雕咐续功劣晶警缘尿昏遇撑万压镰肿希导猛晌挎横努潮套拿洲即喇竟宜尖苹以区辣蹦士特卖饺雪方忆扒刃铜形桑稀狸构崭括茅家判呈阵辞甜遣怜军牌土嫩介间下胶闷呜忠皮愁诚雁勉票盼阅系摔详乖栽群刻担品摧屠顿诊吵乘泼岛极筹吼唉穿择跃轿曲器装李二还遗父弯报推参谅孕誓净冻唇瓣归农陵安旨杀馒饿披砍赞牙捏汗克感城邀拌匀员匙景翁依捎卫去刘醒爱健浪熔萍寨恩心等名层散交余歉惰廊叹运绞旁愚损溜针睬岂吗码坊缩华叙营煎宁甘义辅逐严占奔矛过扇教株我危份僚滩挤为玉次您签市痰副坚葬词创勿档州美珍猾尘谱霉疆条捕售灵渴捷达邪鸦纽暖骤椒驳出尾集便战委面俗非渡滔控洗枝容抵亿谋稿订醉吃援芹饰反喜哗估语始哥添获默慎臂洋雅苏纪锅先港南蚁材芬雾早些耳济断店脸钟件拳捞茂垃程卵框孟洒物庆宏督帮垂海沫宝堂颂消态被疗童饲绪虑窝掠划遮所油治升门抱而住月栏遥枯巡肾明符烛杂冈馆呆渐吸怕趋康索沃型招稼鞠彩结魂不激梳否堵的致真普湿换厨钉声求壁俭设辰泉碰勤炼迁狗届合建盗阿急飞丙弹矩厉坑赏汤晨处吧记毒主贩葱掀途霞放乒快庭狼剪刷汪糕匹着肥脆乙嫌案糖从苍歌衫倦稳漆涝艰胸绝跨阔厦猜级咸左劳剥失询爹观县芝鸽终盐胜拜呢跪鹅惠伏炎腰雷氏蜘束恶校气停单吴泪陈率辜焦脊勾越呀粮往障风梢对句目增骑注森存灰曾弊敲街晓搅刺肤粥拉威杰刊苦汉置责膀本找枣墨字政柴辩碗福乌高脏梨纷精揪贱袄广派惧亦绑底诸识禁自囊术御汁乎思钥聚天础冰偷榨嚷犯里音庄宿烘矿菠抖炊胁挡扬裕昨欢愉们圾买除腔喉蜓巾省乐药搬尺奸习伤多艘辟东殃遭篇利崇贝萌锹谈椅";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        int res = newsService.create(news);
        assertTrue(res > 0);
    }

    @Test
    public void IT_TD_003_002_001_003() {
        int id = 1;
        String title = "缓济漏初迹隐立服秩赵测节辅获稠劲栗贷萍础既咬录役阔栽敢坚蕉援皂鲁洗鸣市倡茄宴轰愉核习饮笑字宅找桥治缴";
        String content = "券蒙韵幼但女哑镇烟裙应仰落陷懒寸鲁白绘杆臭墓叮罩眼袋冤网坟亲蒜蚂避弟撇典叨颈旗躲一五袭耕予亏揉权立燕追题锈止平渗接禽搂填暑顽晴开辆丑鼓剃铺震易锐首疑妹笨概鄙社及桶爆武柱炭顾叶财款页睡蹈拦蔬负贡俯插虹拢老亡漠幅贤迷邮熊赢宋拴三膜呼塌驰乳紫抄半侦览国保残孝勒执笼甚仓拨旧尼阁想耍惹剩歪是值金期约翠奴博坛夹叠四同毯忌崖缴蚀井腥挺户勇尸恢祖霸渣握片吞沾伟么定慧凡糠支侄墙基贞喂劲疯汽搏罢险弓仍妨且冷发夺伯击悉朵确已圆饥说夜姨逝强夕猪塘踢送膨切扭筝统序睁拾嫂桃耀旋翻毁馋匠窃宽狡暂泊铲垒站娘凉趁盆太和航洽田付挖钱律摊牵测缎烈芦释纠隶轧碌七朗邻姜征知弄妻叛饼雨阳貌浴守嚼潜此捆带宅泛悲滴躁丸颜免也该翅岗煌屈像叉购贷笑缓艇顷巩抢粱干荣刚伸今涉讲孩宇溪脚渠削组己脖咽朝虚头炒云僵晋怎毙梅透乏赖戚江雀冠医番域个双连肩悟起卷焰朋携司欠低破炮哪兄恨秩槽钞钳屯娃幕慰掘筋望悼彻梦只疼羊币洞壶秀恭著路屑钻粒侨巧这采醋别翼宵棉眯信进俊絮玻扎才探边辨蛋佛樱钓菊榜虏漫沟脱躺肃王腿作岭扛哨川撤秘芽笋好扔岁碍译肉居厌疮乓窑愧共微庙又薄凶鸟整瓦虎址务忽画般慌北犬债节轻日隔待懂光郑浆积贸袖搜郎经异狐则茧挂宗耐显难粘逗肚聪葡床棋贯古企巨粪石青足称逆促畅械演毛蜻孔传析纵休煮贴竹改每引害滨脉承幻操轨跟央神蓝星证蛛库口吩跳得蜜略替动竖隙涂柄讯随昆炉霜近怨预杨帖芒活敏诗搞细场拆俘某镜拘恐两延时裤峡楚封宰忘言驴块位其浩伶张卸准道热谨由听斥代拒现罚写甩做身示管书数原野膏施表灭晒祸峰斩庸跌魄辫薪蛾考鉴惭轰生享扣趣陶尽授据淋就超堆挑矮晃迅师受衔羡血兴谣脾旺诵苗养手狱祥谜铁盘变果赶步锯昼看挥议内爷旬剑米项技环至刑君育象拼射慕掏把驶删话既爪违季箭徒办绩架性淘灿餐外它袜哄摇辛泡讨劫啦迫联扶完胆瘦聋爸零讽湖辱颤闸惕疫例斯串舍塑丰册铸靠队英充姿如麦末陕源移弱秒正痒维忧亭愤锡衰肺喝趴铃红涌未萄各策年麻琴样敌啄众屡鹊煤堡薯贫肌谢验竭盟驼寇撒六俩盾情降宫惯葵廉意藏蝴揭糊标宙秋更电贵林扩式役岩饱八馅敞图剧槐莲映厚乔村兔会棕启膊碎智当决无速织暗京夫久并商用戒爬暮扯隐爽荐凑拖烤仅敢兵礼官蜡盈倍窜沿鬼啊船旦埋厘帘百较摄她临窄娱雹错告具扫幸瞎退胳夸裂桌短豆距述稠销纹工宾倡泄文诉搭蚊瞒部籍录寒骆献坡废备掌舞花贼视初鸭仔读收理冬泳露寺人兆坏皱逢挣兼污谎腾磁倘痛婚粉怀留狮瓶昂回罪检燥佳茎衡帜灶舟盲继弃房丁鱼地浑巷取族浙牛隆抓申描累骨跑沸乱洁最舱究男质段输哀敬绕咳课密仿觉缠骄提慨鸡怒染产艳股夏彼冒纯斜影鼻溉俱吹踏垦嗓抛恰者捐练实畏规虽限眠酱偏火眨鼠鸣掩笛辉量饭歇柔扑解党指逃防垄香拍富董永适迈疲侧怪抚暴汇耽仇凝算鞋浸伞少计茫旅绳擦益了旷喷绣怠阻肠丘熟笔科蚕勺蔽惩浓锦炸偶滑民盛偿弦抹蠢婆牧满蛇妥席贿制额减振都托审侍阴愿割训浇牢论烧滋岸甲试祝浊儿胞轮包绿何葛递袍入再奇供嘱木遵踩糟脑迟盖斗稍扮按胡互周后陡研宴珠访妄菜毫繁伙败栗然颗渔毅货亩水尊触胖膝婶忍齐橘尤陪筒淡草奥骗展剂哈缝枪效钢蓬舰与棚咏若照傍钩吊燃登衣柿摸蛙吐固西滥桐龟软拔蹄浅境中雄阀化磨沉重黑稻腹帐树选循牺团比岔侵攀茶抗任冶借梯妈绵酿诱棍播印使贺兰润贪泽竞劈午费种凤山攻拥秆专奋池痕慢络唤怖波柳版味璃兽误够必持常腊属逮子肝熄寄批荡刀晕吨巴资领点仪饶坐赵犹碧筐窗魔黄剖箱清春梁哲恒评度粗尚排范滤秤棵姑察乡佩殖锤将或斤总长穗斑唯壤覆迎圣坦刮革键拐折修车朽小筑均响挠机候欣扰涛烦沙伴榆龙誉姓突亮背右纳撕顺附号泻丽诞凳烂皆调助奶布疤伪学困假法皇允狠事酒昌鹰锣座唐谊认尝湾编瑞令善徐丈线卧鹿猎闪捉摘驾你乞杯泰催素良践料押园相孙悠惜谦羞混税蜂伐垫寿戴势闲绒几氧故前芳元链脂堪悬膛史能简垮旱转台涨全盏新欧模板大津离楼茄劝母租姥造历独丝肯价灯倚挪鞭荷静胃角抽驻服喊纱监职圈闭向松来裁赔界淹烫世给倾抬打行傅捧玩帆锻酸伍缺塞纲铅要箩羽栋颠疏扁睛死植匆黎漂宣纸忙鲜第畜骂举奖盒壳蔑虾私踪叫分耗念赛愈绍丢倒宪命骡裳召漏撞请奏闹须章查河砌公走桥唱却豪列顶桨塔缸类躬殿况紧奉腐赤冲盯仆厕赚九滚乃仁症辈摆嘉澡傻悄蛮病配匪之恼罐食闻院饮郊培裹耻摩拣疾趟球成戏协碑友志妖蕉帝蹲妙关空千屋那舅卜需罗上有深孤娇格让悔棒沈灌很厅毕龄酷搁蓄蒸马肢臣含赴游眉直柏酬绢榴浮谁复核差端歼穷流舒恋见励竿朱围惨衬惊远枕谷根护桂狭许杜橡瞧遍瓜侮洪蝇蝶悦陆灾牲嘴于僻猫锄储色客温壮纺优赠卡德加因帽业返驱犁通秧泥在患局救府可他仗屿欲柜丹叔锁篮寻争惑亚赌吓虫十禾逼息佣似筛姐砖殊什闯叼挨恳液问截菌阶融莫姻咱凭狂炕室肆锋丧厂载凯螺欺投杠丛帅秃际斧胀力辽掉迹吉喘班哭妇堤答坝傲绸挽银到仙慈皂径飘艺猴没荒齿朴咬晚嫁杏硬体状舌纤嗽捡补穴另萝雕咐续功劣晶警缘尿昏遇撑万压镰肿希导猛晌挎横努潮套拿洲即喇竟宜尖苹以区辣蹦士特卖饺雪方忆扒刃铜形桑稀狸构崭括茅家判呈阵辞甜遣怜军牌土嫩介间下胶闷呜忠皮愁诚雁勉票盼阅系摔详乖栽群刻担品摧屠顿诊吵乘泼岛极筹吼唉穿择跃轿曲器装李二还遗父弯报推参谅孕誓净冻唇瓣归农陵安旨杀馒饿披砍赞牙捏汗克感城邀拌匀员匙景翁依捎卫去刘醒爱健浪熔萍寨恩心等名层散交余歉惰廊叹运绞旁愚损溜针睬岂吗码坊缩华叙营煎宁甘义辅逐严占奔矛过扇教株我危份僚滩挤为玉次您签市痰副坚葬词创勿档州美珍猾尘谱霉疆条捕售灵渴捷达邪鸦纽暖骤椒驳出尾集便战委面俗非渡滔控洗枝容抵亿谋稿订醉吃援芹饰反喜哗估语始哥添获默慎臂洋雅苏纪锅先港南蚁材芬雾早些耳济断店脸钟件拳捞茂垃程卵框孟洒物庆宏督帮垂海沫宝堂颂消态被疗童饲绪虑窝掠划遮所油治升门抱而住月栏遥枯巡肾明符烛杂冈馆呆渐吸怕趋康索沃型招稼鞠彩结魂不激梳否堵的致真普湿换厨钉声求壁俭设辰泉碰勤炼迁狗届合建盗阿急飞丙弹矩厉坑赏汤晨处吧记毒主贩葱掀途霞放乒快庭狼剪刷汪糕匹着肥脆乙嫌案糖从苍歌衫倦稳漆涝艰胸绝跨阔厦猜级咸左劳剥失询爹观县芝鸽终盐胜拜呢跪鹅惠伏炎腰雷氏蜘束恶校气停单吴泪陈率辜焦脊勾越呀粮往障风梢对句目增骑注森存灰曾弊敲街晓搅刺肤粥拉威杰刊苦汉置责膀本找枣墨字政柴辩碗福乌高脏梨纷精揪贱袄广派惧亦绑底诸识禁自囊术御汁乎思钥聚天础冰偷榨嚷犯里音庄宿烘矿菠抖炊胁挡扬裕昨欢愉们圾买除腔喉蜓巾省乐药搬尺奸习伤多艘辟东殃遭篇利崇贝萌锹谈椅";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        int res = newsService.create(news);
        assertTrue(res > 0);
    }

    @Test
    public void IT_TD_003_002_001_004() {
        int id = 1;
        String title = "房虽耳圾路称瞧铺的滔标座茶哈姨卷坛才极韵作纤挡溉昏磁项泻博昌窄树见涝蹈练你兔富么波冤眠竖某仇果芬害膝菜轧太搂慎冬下锄予河笼找佣纹通摄炒抬厚仗蜘竞尝愚夜锋高汇脱椅凡兽携裁健亦歼及有喇隆抗贝物纲";
        String content = "券蒙韵幼但女哑镇烟裙应仰落陷懒寸鲁白绘杆臭墓叮罩眼袋冤网坟亲蒜蚂避弟撇典叨颈旗躲一五袭耕予亏揉权立燕追题锈止平渗接禽搂填暑顽晴开辆丑鼓剃铺震易锐首疑妹笨概鄙社及桶爆武柱炭顾叶财款页睡蹈拦蔬负贡俯插虹拢老亡漠幅贤迷邮熊赢宋拴三膜呼塌驰乳紫抄半侦览国保残孝勒执笼甚仓拨旧尼阁想耍惹剩歪是值金期约翠奴博坛夹叠四同毯忌崖缴蚀井腥挺户勇尸恢祖霸渣握片吞沾伟么定慧凡糠支侄墙基贞喂劲疯汽搏罢险弓仍妨且冷发夺伯击悉朵确已圆饥说夜姨逝强夕猪塘踢送膨切扭筝统序睁拾嫂桃耀旋翻毁馋匠窃宽狡暂泊铲垒站娘凉趁盆太和航洽田付挖钱律摊牵测缎烈芦释纠隶轧碌七朗邻姜征知弄妻叛饼雨阳貌浴守嚼潜此捆带宅泛悲滴躁丸颜免也该翅岗煌屈像叉购贷笑缓艇顷巩抢粱干荣刚伸今涉讲孩宇溪脚渠削组己脖咽朝虚头炒云僵晋怎毙梅透乏赖戚江雀冠医番域个双连肩悟起卷焰朋携司欠低破炮哪兄恨秩槽钞钳屯娃幕慰掘筋望悼彻梦只疼羊币洞壶秀恭著路屑钻粒侨巧这采醋别翼宵棉眯信进俊絮玻扎才探边辨蛋佛樱钓菊榜虏漫沟脱躺肃王腿作岭扛哨川撤秘芽笋好扔岁碍译肉居厌疮乓窑愧共微庙又薄凶鸟整瓦虎址务忽画般慌北犬债节轻日隔待懂光郑浆积贸袖搜郎经异狐则茧挂宗耐显难粘逗肚聪葡床棋贯古企巨粪石青足称逆促畅械演毛蜻孔传析纵休煮贴竹改每引害滨脉承幻操轨跟央神蓝星证蛛库口吩跳得蜜略替动竖隙涂柄讯随昆炉霜近怨预杨帖芒活敏诗搞细场拆俘某镜拘恐两延时裤峡楚封宰忘言驴块位其浩伶张卸准道热谨由听斥代拒现罚写甩做身示管书数原野膏施表灭晒祸峰斩庸跌魄辫薪蛾考鉴惭轰生享扣趣陶尽授据淋就超堆挑矮晃迅师受衔羡血兴谣脾旺诵苗养手狱祥谜铁盘变果赶步锯昼看挥议内爷旬剑米项技环至刑君育象拼射慕掏把驶删话既爪违季箭徒办绩架性淘灿餐外它袜哄摇辛泡讨劫啦迫联扶完胆瘦聋爸零讽湖辱颤闸惕疫例斯串舍塑丰册铸靠队英充姿如麦末陕源移弱秒正痒维忧亭愤锡衰肺喝趴铃红涌未萄各策年麻琴样敌啄众屡鹊煤堡薯贫肌谢验竭盟驼寇撒六俩盾情降宫惯葵廉意藏蝴揭糊标宙秋更电贵林扩式役岩饱八馅敞图剧槐莲映厚乔村兔会棕启膊碎智当决无速织暗京夫久并商用戒爬暮扯隐爽荐凑拖烤仅敢兵礼官蜡盈倍窜沿鬼啊船旦埋厘帘百较摄她临窄娱雹错告具扫幸瞎退胳夸裂桌短豆距述稠销纹工宾倡泄文诉搭蚊瞒部籍录寒骆献坡废备掌舞花贼视初鸭仔读收理冬泳露寺人兆坏皱逢挣兼污谎腾磁倘痛婚粉怀留狮瓶昂回罪检燥佳茎衡帜灶舟盲继弃房丁鱼地浑巷取族浙牛隆抓申描累骨跑沸乱洁最舱究男质段输哀敬绕咳课密仿觉缠骄提慨鸡怒染产艳股夏彼冒纯斜影鼻溉俱吹踏垦嗓抛恰者捐练实畏规虽限眠酱偏火眨鼠鸣掩笛辉量饭歇柔扑解党指逃防垄香拍富董永适迈疲侧怪抚暴汇耽仇凝算鞋浸伞少计茫旅绳擦益了旷喷绣怠阻肠丘熟笔科蚕勺蔽惩浓锦炸偶滑民盛偿弦抹蠢婆牧满蛇妥席贿制额减振都托审侍阴愿割训浇牢论烧滋岸甲试祝浊儿胞轮包绿何葛递袍入再奇供嘱木遵踩糟脑迟盖斗稍扮按胡互周后陡研宴珠访妄菜毫繁伙败栗然颗渔毅货亩水尊触胖膝婶忍齐橘尤陪筒淡草奥骗展剂哈缝枪效钢蓬舰与棚咏若照傍钩吊燃登衣柿摸蛙吐固西滥桐龟软拔蹄浅境中雄阀化磨沉重黑稻腹帐树选循牺团比岔侵攀茶抗任冶借梯妈绵酿诱棍播印使贺兰润贪泽竞劈午费种凤山攻拥秆专奋池痕慢络唤怖波柳版味璃兽误够必持常腊属逮子肝熄寄批荡刀晕吨巴资领点仪饶坐赵犹碧筐窗魔黄剖箱清春梁哲恒评度粗尚排范滤秤棵姑察乡佩殖锤将或斤总长穗斑唯壤覆迎圣坦刮革键拐折修车朽小筑均响挠机候欣扰涛烦沙伴榆龙誉姓突亮背右纳撕顺附号泻丽诞凳烂皆调助奶布疤伪学困假法皇允狠事酒昌鹰锣座唐谊认尝湾编瑞令善徐丈线卧鹿猎闪捉摘驾你乞杯泰催素良践料押园相孙悠惜谦羞混税蜂伐垫寿戴势闲绒几氧故前芳元链脂堪悬膛史能简垮旱转台涨全盏新欧模板大津离楼茄劝母租姥造历独丝肯价灯倚挪鞭荷静胃角抽驻服喊纱监职圈闭向松来裁赔界淹烫世给倾抬打行傅捧玩帆锻酸伍缺塞纲铅要箩羽栋颠疏扁睛死植匆黎漂宣纸忙鲜第畜骂举奖盒壳蔑虾私踪叫分耗念赛愈绍丢倒宪命骡裳召漏撞请奏闹须章查河砌公走桥唱却豪列顶桨塔缸类躬殿况紧奉腐赤冲盯仆厕赚九滚乃仁症辈摆嘉澡傻悄蛮病配匪之恼罐食闻院饮郊培裹耻摩拣疾趟球成戏协碑友志妖蕉帝蹲妙关空千屋那舅卜需罗上有深孤娇格让悔棒沈灌很厅毕龄酷搁蓄蒸马肢臣含赴游眉直柏酬绢榴浮谁复核差端歼穷流舒恋见励竿朱围惨衬惊远枕谷根护桂狭许杜橡瞧遍瓜侮洪蝇蝶悦陆灾牲嘴于僻猫锄储色客温壮纺优赠卡德加因帽业返驱犁通秧泥在患局救府可他仗屿欲柜丹叔锁篮寻争惑亚赌吓虫十禾逼息佣似筛姐砖殊什闯叼挨恳液问截菌阶融莫姻咱凭狂炕室肆锋丧厂载凯螺欺投杠丛帅秃际斧胀力辽掉迹吉喘班哭妇堤答坝傲绸挽银到仙慈皂径飘艺猴没荒齿朴咬晚嫁杏硬体状舌纤嗽捡补穴另萝雕咐续功劣晶警缘尿昏遇撑万压镰肿希导猛晌挎横努潮套拿洲即喇竟宜尖苹以区辣蹦士特卖饺雪方忆扒刃铜形桑稀狸构崭括茅家判呈阵辞甜遣怜军牌土嫩介间下胶闷呜忠皮愁诚雁勉票盼阅系摔详乖栽群刻担品摧屠顿诊吵乘泼岛极筹吼唉穿择跃轿曲器装李二还遗父弯报推参谅孕誓净冻唇瓣归农陵安旨杀馒饿披砍赞牙捏汗克感城邀拌匀员匙景翁依捎卫去刘醒爱健浪熔萍寨恩心等名层散交余歉惰廊叹运绞旁愚损溜针睬岂吗码坊缩华叙营煎宁甘义辅逐严占奔矛过扇教株我危份僚滩挤为玉次您签市痰副坚葬词创勿档州美珍猾尘谱霉疆条捕售灵渴捷达邪鸦纽暖骤椒驳出尾集便战委面俗非渡滔控洗枝容抵亿谋稿订醉吃援芹饰反喜哗估语始哥添获默慎臂洋雅苏纪锅先港南蚁材芬雾早些耳济断店脸钟件拳捞茂垃程卵框孟洒物庆宏督帮垂海沫宝堂颂消态被疗童饲绪虑窝掠划遮所油治升门抱而住月栏遥枯巡肾明符烛杂冈馆呆渐吸怕趋康索沃型招稼鞠彩结魂不激梳否堵的致真普湿换厨钉声求壁俭设辰泉碰勤炼迁狗届合建盗阿急飞丙弹矩厉坑赏汤晨处吧记毒主贩葱掀途霞放乒快庭狼剪刷汪糕匹着肥脆乙嫌案糖从苍歌衫倦稳漆涝艰胸绝跨阔厦猜级咸左劳剥失询爹观县芝鸽终盐胜拜呢跪鹅惠伏炎腰雷氏蜘束恶校气停单吴泪陈率辜焦脊勾越呀粮往障风梢对句目增骑注森存灰曾弊敲街晓搅刺肤粥拉威杰刊苦汉置责膀本找枣墨字政柴辩碗福乌高脏梨纷精揪贱袄广派惧亦绑底诸识禁自囊术御汁乎思钥聚天础冰偷榨嚷犯里音庄宿烘矿菠抖炊胁挡扬裕昨欢愉们圾买除腔喉蜓巾省乐药搬尺奸习伤多艘辟东殃遭篇利崇贝萌锹谈椅";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        int res = newsService.create(news);
        assertTrue(res > 0);
    }

    @Test
    public void IT_TD_003_002_001_005() {
        int id = 1;
        String title = "京增独浩直爽错舒匆局美羊吴搁赏旁炭辽秋惹风怖淘扁着凉古折壶存粒灿咏惧谜替贡冬薯空锡蹈红提擦厌瑞散坡那悉暗尊壁饮野伙索扎宙横临津发饭欧抓前始骑亩亮旺堂锐轨懒白涉柴奥良怨营齿茎气正偷爸未谋垦我竖最游热李析";
        String content = "券蒙韵幼但女哑镇烟裙应仰落陷懒寸鲁白绘杆臭墓叮罩眼袋冤网坟亲蒜蚂避弟撇典叨颈旗躲一五袭耕予亏揉权立燕追题锈止平渗接禽搂填暑顽晴开辆丑鼓剃铺震易锐首疑妹笨概鄙社及桶爆武柱炭顾叶财款页睡蹈拦蔬负贡俯插虹拢老亡漠幅贤迷邮熊赢宋拴三膜呼塌驰乳紫抄半侦览国保残孝勒执笼甚仓拨旧尼阁想耍惹剩歪是值金期约翠奴博坛夹叠四同毯忌崖缴蚀井腥挺户勇尸恢祖霸渣握片吞沾伟么定慧凡糠支侄墙基贞喂劲疯汽搏罢险弓仍妨且冷发夺伯击悉朵确已圆饥说夜姨逝强夕猪塘踢送膨切扭筝统序睁拾嫂桃耀旋翻毁馋匠窃宽狡暂泊铲垒站娘凉趁盆太和航洽田付挖钱律摊牵测缎烈芦释纠隶轧碌七朗邻姜征知弄妻叛饼雨阳貌浴守嚼潜此捆带宅泛悲滴躁丸颜免也该翅岗煌屈像叉购贷笑缓艇顷巩抢粱干荣刚伸今涉讲孩宇溪脚渠削组己脖咽朝虚头炒云僵晋怎毙梅透乏赖戚江雀冠医番域个双连肩悟起卷焰朋携司欠低破炮哪兄恨秩槽钞钳屯娃幕慰掘筋望悼彻梦只疼羊币洞壶秀恭著路屑钻粒侨巧这采醋别翼宵棉眯信进俊絮玻扎才探边辨蛋佛樱钓菊榜虏漫沟脱躺肃王腿作岭扛哨川撤秘芽笋好扔岁碍译肉居厌疮乓窑愧共微庙又薄凶鸟整瓦虎址务忽画般慌北犬债节轻日隔待懂光郑浆积贸袖搜郎经异狐则茧挂宗耐显难粘逗肚聪葡床棋贯古企巨粪石青足称逆促畅械演毛蜻孔传析纵休煮贴竹改每引害滨脉承幻操轨跟央神蓝星证蛛库口吩跳得蜜略替动竖隙涂柄讯随昆炉霜近怨预杨帖芒活敏诗搞细场拆俘某镜拘恐两延时裤峡楚封宰忘言驴块位其浩伶张卸准道热谨由听斥代拒现罚写甩做身示管书数原野膏施表灭晒祸峰斩庸跌魄辫薪蛾考鉴惭轰生享扣趣陶尽授据淋就超堆挑矮晃迅师受衔羡血兴谣脾旺诵苗养手狱祥谜铁盘变果赶步锯昼看挥议内爷旬剑米项技环至刑君育象拼射慕掏把驶删话既爪违季箭徒办绩架性淘灿餐外它袜哄摇辛泡讨劫啦迫联扶完胆瘦聋爸零讽湖辱颤闸惕疫例斯串舍塑丰册铸靠队英充姿如麦末陕源移弱秒正痒维忧亭愤锡衰肺喝趴铃红涌未萄各策年麻琴样敌啄众屡鹊煤堡薯贫肌谢验竭盟驼寇撒六俩盾情降宫惯葵廉意藏蝴揭糊标宙秋更电贵林扩式役岩饱八馅敞图剧槐莲映厚乔村兔会棕启膊碎智当决无速织暗京夫久并商用戒爬暮扯隐爽荐凑拖烤仅敢兵礼官蜡盈倍窜沿鬼啊船旦埋厘帘百较摄她临窄娱雹错告具扫幸瞎退胳夸裂桌短豆距述稠销纹工宾倡泄文诉搭蚊瞒部籍录寒骆献坡废备掌舞花贼视初鸭仔读收理冬泳露寺人兆坏皱逢挣兼污谎腾磁倘痛婚粉怀留狮瓶昂回罪检燥佳茎衡帜灶舟盲继弃房丁鱼地浑巷取族浙牛隆抓申描累骨跑沸乱洁最舱究男质段输哀敬绕咳课密仿觉缠骄提慨鸡怒染产艳股夏彼冒纯斜影鼻溉俱吹踏垦嗓抛恰者捐练实畏规虽限眠酱偏火眨鼠鸣掩笛辉量饭歇柔扑解党指逃防垄香拍富董永适迈疲侧怪抚暴汇耽仇凝算鞋浸伞少计茫旅绳擦益了旷喷绣怠阻肠丘熟笔科蚕勺蔽惩浓锦炸偶滑民盛偿弦抹蠢婆牧满蛇妥席贿制额减振都托审侍阴愿割训浇牢论烧滋岸甲试祝浊儿胞轮包绿何葛递袍入再奇供嘱木遵踩糟脑迟盖斗稍扮按胡互周后陡研宴珠访妄菜毫繁伙败栗然颗渔毅货亩水尊触胖膝婶忍齐橘尤陪筒淡草奥骗展剂哈缝枪效钢蓬舰与棚咏若照傍钩吊燃登衣柿摸蛙吐固西滥桐龟软拔蹄浅境中雄阀化磨沉重黑稻腹帐树选循牺团比岔侵攀茶抗任冶借梯妈绵酿诱棍播印使贺兰润贪泽竞劈午费种凤山攻拥秆专奋池痕慢络唤怖波柳版味璃兽误够必持常腊属逮子肝熄寄批荡刀晕吨巴资领点仪饶坐赵犹碧筐窗魔黄剖箱清春梁哲恒评度粗尚排范滤秤棵姑察乡佩殖锤将或斤总长穗斑唯壤覆迎圣坦刮革键拐折修车朽小筑均响挠机候欣扰涛烦沙伴榆龙誉姓突亮背右纳撕顺附号泻丽诞凳烂皆调助奶布疤伪学困假法皇允狠事酒昌鹰锣座唐谊认尝湾编瑞令善徐丈线卧鹿猎闪捉摘驾你乞杯泰催素良践料押园相孙悠惜谦羞混税蜂伐垫寿戴势闲绒几氧故前芳元链脂堪悬膛史能简垮旱转台涨全盏新欧模板大津离楼茄劝母租姥造历独丝肯价灯倚挪鞭荷静胃角抽驻服喊纱监职圈闭向松来裁赔界淹烫世给倾抬打行傅捧玩帆锻酸伍缺塞纲铅要箩羽栋颠疏扁睛死植匆黎漂宣纸忙鲜第畜骂举奖盒壳蔑虾私踪叫分耗念赛愈绍丢倒宪命骡裳召漏撞请奏闹须章查河砌公走桥唱却豪列顶桨塔缸类躬殿况紧奉腐赤冲盯仆厕赚九滚乃仁症辈摆嘉澡傻悄蛮病配匪之恼罐食闻院饮郊培裹耻摩拣疾趟球成戏协碑友志妖蕉帝蹲妙关空千屋那舅卜需罗上有深孤娇格让悔棒沈灌很厅毕龄酷搁蓄蒸马肢臣含赴游眉直柏酬绢榴浮谁复核差端歼穷流舒恋见励竿朱围惨衬惊远枕谷根护桂狭许杜橡瞧遍瓜侮洪蝇蝶悦陆灾牲嘴于僻猫锄储色客温壮纺优赠卡德加因帽业返驱犁通秧泥在患局救府可他仗屿欲柜丹叔锁篮寻争惑亚赌吓虫十禾逼息佣似筛姐砖殊什闯叼挨恳液问截菌阶融莫姻咱凭狂炕室肆锋丧厂载凯螺欺投杠丛帅秃际斧胀力辽掉迹吉喘班哭妇堤答坝傲绸挽银到仙慈皂径飘艺猴没荒齿朴咬晚嫁杏硬体状舌纤嗽捡补穴另萝雕咐续功劣晶警缘尿昏遇撑万压镰肿希导猛晌挎横努潮套拿洲即喇竟宜尖苹以区辣蹦士特卖饺雪方忆扒刃铜形桑稀狸构崭括茅家判呈阵辞甜遣怜军牌土嫩介间下胶闷呜忠皮愁诚雁勉票盼阅系摔详乖栽群刻担品摧屠顿诊吵乘泼岛极筹吼唉穿择跃轿曲器装李二还遗父弯报推参谅孕誓净冻唇瓣归农陵安旨杀馒饿披砍赞牙捏汗克感城邀拌匀员匙景翁依捎卫去刘醒爱健浪熔萍寨恩心等名层散交余歉惰廊叹运绞旁愚损溜针睬岂吗码坊缩华叙营煎宁甘义辅逐严占奔矛过扇教株我危份僚滩挤为玉次您签市痰副坚葬词创勿档州美珍猾尘谱霉疆条捕售灵渴捷达邪鸦纽暖骤椒驳出尾集便战委面俗非渡滔控洗枝容抵亿谋稿订醉吃援芹饰反喜哗估语始哥添获默慎臂洋雅苏纪锅先港南蚁材芬雾早些耳济断店脸钟件拳捞茂垃程卵框孟洒物庆宏督帮垂海沫宝堂颂消态被疗童饲绪虑窝掠划遮所油治升门抱而住月栏遥枯巡肾明符烛杂冈馆呆渐吸怕趋康索沃型招稼鞠彩结魂不激梳否堵的致真普湿换厨钉声求壁俭设辰泉碰勤炼迁狗届合建盗阿急飞丙弹矩厉坑赏汤晨处吧记毒主贩葱掀途霞放乒快庭狼剪刷汪糕匹着肥脆乙嫌案糖从苍歌衫倦稳漆涝艰胸绝跨阔厦猜级咸左劳剥失询爹观县芝鸽终盐胜拜呢跪鹅惠伏炎腰雷氏蜘束恶校气停单吴泪陈率辜焦脊勾越呀粮往障风梢对句目增骑注森存灰曾弊敲街晓搅刺肤粥拉威杰刊苦汉置责膀本找枣墨字政柴辩碗福乌高脏梨纷精揪贱袄广派惧亦绑底诸识禁自囊术御汁乎思钥聚天础冰偷榨嚷犯里音庄宿烘矿菠抖炊胁挡扬裕昨欢愉们圾买除腔喉蜓巾省乐药搬尺奸习伤多艘辟东殃遭篇利崇贝萌锹谈椅";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        int res = newsService.create(news);
        assertTrue(res > 0);
    }

    @Test
    public void IT_TD_003_002_001_006() {
        int id = 1;
        String title = "京增独浩直爽错舒匆局美羊吴搁赏旁炭辽秋惹风怖淘扁着凉古折壶存粒灿咏惧谜替贡冬薯空锡蹈红提擦厌瑞散坡那悉暗尊壁饮野你伙索扎宙横临津发饭欧抓前始骑亩亮旺堂锐轨懒白涉柴奥良怨营齿茎气正偷爸未谋垦我竖最游热李析";
        String content = "券蒙韵幼但女哑镇烟裙应仰落陷懒寸鲁白绘杆臭墓叮罩眼袋冤网坟亲蒜蚂避弟撇典叨颈旗躲一五袭耕予亏揉权立燕追题锈止平渗接禽搂填暑顽晴开辆丑鼓剃铺震易锐首疑妹笨概鄙社及桶爆武柱炭顾叶财款页睡蹈拦蔬负贡俯插虹拢老亡漠幅贤迷邮熊赢宋拴三膜呼塌驰乳紫抄半侦览国保残孝勒执笼甚仓拨旧尼阁想耍惹剩歪是值金期约翠奴博坛夹叠四同毯忌崖缴蚀井腥挺户勇尸恢祖霸渣握片吞沾伟么定慧凡糠支侄墙基贞喂劲疯汽搏罢险弓仍妨且冷发夺伯击悉朵确已圆饥说夜姨逝强夕猪塘踢送膨切扭筝统序睁拾嫂桃耀旋翻毁馋匠窃宽狡暂泊铲垒站娘凉趁盆太和航洽田付挖钱律摊牵测缎烈芦释纠隶轧碌七朗邻姜征知弄妻叛饼雨阳貌浴守嚼潜此捆带宅泛悲滴躁丸颜免也该翅岗煌屈像叉购贷笑缓艇顷巩抢粱干荣刚伸今涉讲孩宇溪脚渠削组己脖咽朝虚头炒云僵晋怎毙梅透乏赖戚江雀冠医番域个双连肩悟起卷焰朋携司欠低破炮哪兄恨秩槽钞钳屯娃幕慰掘筋望悼彻梦只疼羊币洞壶秀恭著路屑钻粒侨巧这采醋别翼宵棉眯信进俊絮玻扎才探边辨蛋佛樱钓菊榜虏漫沟脱躺肃王腿作岭扛哨川撤秘芽笋好扔岁碍译肉居厌疮乓窑愧共微庙又薄凶鸟整瓦虎址务忽画般慌北犬债节轻日隔待懂光郑浆积贸袖搜郎经异狐则茧挂宗耐显难粘逗肚聪葡床棋贯古企巨粪石青足称逆促畅械演毛蜻孔传析纵休煮贴竹改每引害滨脉承幻操轨跟央神蓝星证蛛库口吩跳得蜜略替动竖隙涂柄讯随昆炉霜近怨预杨帖芒活敏诗搞细场拆俘某镜拘恐两延时裤峡楚封宰忘言驴块位其浩伶张卸准道热谨由听斥代拒现罚写甩做身示管书数原野膏施表灭晒祸峰斩庸跌魄辫薪蛾考鉴惭轰生享扣趣陶尽授据淋就超堆挑矮晃迅师受衔羡血兴谣脾旺诵苗养手狱祥谜铁盘变果赶步锯昼看挥议内爷旬剑米项技环至刑君育象拼射慕掏把驶删话既爪违季箭徒办绩架性淘灿餐外它袜哄摇辛泡讨劫啦迫联扶完胆瘦聋爸零讽湖辱颤闸惕疫例斯串舍塑丰册铸靠队英充姿如麦末陕源移弱秒正痒维忧亭愤锡衰肺喝趴铃红涌未萄各策年麻琴样敌啄众屡鹊煤堡薯贫肌谢验竭盟驼寇撒六俩盾情降宫惯葵廉意藏蝴揭糊标宙秋更电贵林扩式役岩饱八馅敞图剧槐莲映厚乔村兔会棕启膊碎智当决无速织暗京夫久并商用戒爬暮扯隐爽荐凑拖烤仅敢兵礼官蜡盈倍窜沿鬼啊船旦埋厘帘百较摄她临窄娱雹错告具扫幸瞎退胳夸裂桌短豆距述稠销纹工宾倡泄文诉搭蚊瞒部籍录寒骆献坡废备掌舞花贼视初鸭仔读收理冬泳露寺人兆坏皱逢挣兼污谎腾磁倘痛婚粉怀留狮瓶昂回罪检燥佳茎衡帜灶舟盲继弃房丁鱼地浑巷取族浙牛隆抓申描累骨跑沸乱洁最舱究男质段输哀敬绕咳课密仿觉缠骄提慨鸡怒染产艳股夏彼冒纯斜影鼻溉俱吹踏垦嗓抛恰者捐练实畏规虽限眠酱偏火眨鼠鸣掩笛辉量饭歇柔扑解党指逃防垄香拍富董永适迈疲侧怪抚暴汇耽仇凝算鞋浸伞少计茫旅绳擦益了旷喷绣怠阻肠丘熟笔科蚕勺蔽惩浓锦炸偶滑民盛偿弦抹蠢婆牧满蛇妥席贿制额减振都托审侍阴愿割训浇牢论烧滋岸甲试祝浊儿胞轮包绿何葛递袍入再奇供嘱木遵踩糟脑迟盖斗稍扮按胡互周后陡研宴珠访妄菜毫繁伙败栗然颗渔毅货亩水尊触胖膝婶忍齐橘尤陪筒淡草奥骗展剂哈缝枪效钢蓬舰与棚咏若照傍钩吊燃登衣柿摸蛙吐固西滥桐龟软拔蹄浅境中雄阀化磨沉重黑稻腹帐树选循牺团比岔侵攀茶抗任冶借梯妈绵酿诱棍播印使贺兰润贪泽竞劈午费种凤山攻拥秆专奋池痕慢络唤怖波柳版味璃兽误够必持常腊属逮子肝熄寄批荡刀晕吨巴资领点仪饶坐赵犹碧筐窗魔黄剖箱清春梁哲恒评度粗尚排范滤秤棵姑察乡佩殖锤将或斤总长穗斑唯壤覆迎圣坦刮革键拐折修车朽小筑均响挠机候欣扰涛烦沙伴榆龙誉姓突亮背右纳撕顺附号泻丽诞凳烂皆调助奶布疤伪学困假法皇允狠事酒昌鹰锣座唐谊认尝湾编瑞令善徐丈线卧鹿猎闪捉摘驾你乞杯泰催素良践料押园相孙悠惜谦羞混税蜂伐垫寿戴势闲绒几氧故前芳元链脂堪悬膛史能简垮旱转台涨全盏新欧模板大津离楼茄劝母租姥造历独丝肯价灯倚挪鞭荷静胃角抽驻服喊纱监职圈闭向松来裁赔界淹烫世给倾抬打行傅捧玩帆锻酸伍缺塞纲铅要箩羽栋颠疏扁睛死植匆黎漂宣纸忙鲜第畜骂举奖盒壳蔑虾私踪叫分耗念赛愈绍丢倒宪命骡裳召漏撞请奏闹须章查河砌公走桥唱却豪列顶桨塔缸类躬殿况紧奉腐赤冲盯仆厕赚九滚乃仁症辈摆嘉澡傻悄蛮病配匪之恼罐食闻院饮郊培裹耻摩拣疾趟球成戏协碑友志妖蕉帝蹲妙关空千屋那舅卜需罗上有深孤娇格让悔棒沈灌很厅毕龄酷搁蓄蒸马肢臣含赴游眉直柏酬绢榴浮谁复核差端歼穷流舒恋见励竿朱围惨衬惊远枕谷根护桂狭许杜橡瞧遍瓜侮洪蝇蝶悦陆灾牲嘴于僻猫锄储色客温壮纺优赠卡德加因帽业返驱犁通秧泥在患局救府可他仗屿欲柜丹叔锁篮寻争惑亚赌吓虫十禾逼息佣似筛姐砖殊什闯叼挨恳液问截菌阶融莫姻咱凭狂炕室肆锋丧厂载凯螺欺投杠丛帅秃际斧胀力辽掉迹吉喘班哭妇堤答坝傲绸挽银到仙慈皂径飘艺猴没荒齿朴咬晚嫁杏硬体状舌纤嗽捡补穴另萝雕咐续功劣晶警缘尿昏遇撑万压镰肿希导猛晌挎横努潮套拿洲即喇竟宜尖苹以区辣蹦士特卖饺雪方忆扒刃铜形桑稀狸构崭括茅家判呈阵辞甜遣怜军牌土嫩介间下胶闷呜忠皮愁诚雁勉票盼阅系摔详乖栽群刻担品摧屠顿诊吵乘泼岛极筹吼唉穿择跃轿曲器装李二还遗父弯报推参谅孕誓净冻唇瓣归农陵安旨杀馒饿披砍赞牙捏汗克感城邀拌匀员匙景翁依捎卫去刘醒爱健浪熔萍寨恩心等名层散交余歉惰廊叹运绞旁愚损溜针睬岂吗码坊缩华叙营煎宁甘义辅逐严占奔矛过扇教株我危份僚滩挤为玉次您签市痰副坚葬词创勿档州美珍猾尘谱霉疆条捕售灵渴捷达邪鸦纽暖骤椒驳出尾集便战委面俗非渡滔控洗枝容抵亿谋稿订醉吃援芹饰反喜哗估语始哥添获默慎臂洋雅苏纪锅先港南蚁材芬雾早些耳济断店脸钟件拳捞茂垃程卵框孟洒物庆宏督帮垂海沫宝堂颂消态被疗童饲绪虑窝掠划遮所油治升门抱而住月栏遥枯巡肾明符烛杂冈馆呆渐吸怕趋康索沃型招稼鞠彩结魂不激梳否堵的致真普湿换厨钉声求壁俭设辰泉碰勤炼迁狗届合建盗阿急飞丙弹矩厉坑赏汤晨处吧记毒主贩葱掀途霞放乒快庭狼剪刷汪糕匹着肥脆乙嫌案糖从苍歌衫倦稳漆涝艰胸绝跨阔厦猜级咸左劳剥失询爹观县芝鸽终盐胜拜呢跪鹅惠伏炎腰雷氏蜘束恶校气停单吴泪陈率辜焦脊勾越呀粮往障风梢对句目增骑注森存灰曾弊敲街晓搅刺肤粥拉威杰刊苦汉置责膀本找枣墨字政柴辩碗福乌高脏梨纷精揪贱袄广派惧亦绑底诸识禁自囊术御汁乎思钥聚天础冰偷榨嚷犯里音庄宿烘矿菠抖炊胁挡扬裕昨欢愉们圾买除腔喉蜓巾省乐药搬尺奸习伤多艘辟东殃遭篇利崇贝萌锹谈椅";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        assertThrows(RuntimeException.class,
                () -> newsService.create(news));
    }

    @Test
    public void IT_TD_003_002_001_007() {
        int id = 1;
        String title = "";
        String content = "";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        int res = newsService.create(news);
        assertTrue(res > 0);
    }

    @Test
    public void IT_TD_003_002_001_008() {
        int id = 1;
        String title = "";
        String content = "测试测试测试测试测试测试";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        int res = newsService.create(news);
        assertTrue(res > 0);
    }

    @Test
    public void IT_TD_003_002_001_009() {
        int id = 1;
        String title = "";
        String content = "处爪能蒙链住栏端栽权组痕偿昼笨宵耳甘市榴且猫钞轰弯麻粒供愚肢池起本况鸭姑蚊批买绝用兼占摔不吴少散短穗火珠雄拨昌烘腊陆抓快欢浇盆梁朽熊柏丁稿宾降气别船屠悲枕柔照袜种狐捏脉筑姻会隆抽疲岭巾策景坟贺操甜举锯畜丽橡围势孕振设饰档里富择喷样奴衡贫遥拳葡疾岂切症勤升哈屯摆毯豆鬼莫虾雷辰防摄肠脖厚啦蝴紫竞冲尘创招尝究响千版确皆傲侍露禾单晨额尤侦上岩打执赢晓源俩健阶悉缺邮倚投劫鼓狮夸湿滥壶渠宁据斩碎凶闹帮雅位烂榜取迈粮铃给消便糖侧镇毫呆锁辨行支房队雹裹柱搜损盘钥乎事辉亏毕黎集金落高独坏帅第惹寄燕判营闪扯卖扭专堡灰艇兵瞧好自夹黄芝排驴一又令调扑孝震白留抹牛丈隶棕最胡翠什甚绍顽亭费纸香厦领祥件出篇熄吧喘秆价卫痰染梳卸绸娱嚷浙咏增纽泰遮附蒜传双透桑炊逐罪稍夕关沉移溉也联腿币特醉爆怒直薯南寒谅忘惯惊嗓吨蜜末害粗宰强葛猜老环晃冶芒吹赞魂光区坐哑汤藏晴跨签漆施泽松安童绘洲修灵鹊竖请叮袋垄亦誓舰栗诞素编傅仍声持班峰随江瞎临注塑滋炼霞泥粘滚久秘挑将弱污债魄圈丛楼圾烈雁撑古猪骆缸春萍诉盛丸诚乃蜘浸碑耕株椅来成张动骨舒套爷砍哭昂破啄吊揉马辣繁阳瞒扶广八等诵红曲斑睁飘菊役蜓奉枯伟垮觉疼色形姓胃纯妇抛对派跌字点触略笋板羞匪每狱报掩筒简座蹦四答测鹰贪幻政担叠帘球的怪望止腔世私归练挂兔旨十疆其研赴萄宜永庙乔寇促法晶畏躺科饥定崭身戚没搭险躬窗非览齿余喝砖技汉慧录失普闭元道追巷够即资鸣裤格康塞条肥教获仙舟屈岗贵幕天疤厌悦盐庭回谜演汇柳初疑挺统铺暂洁鸡扒宿索许忽枪辅馒棵纳脊提原席颜侄午劳墙朗怕遵载戴抚项怎超英片伯扰肌弊侵陵宴督被携书陡茎情董缎探窝暑么机轿愉皮恳停惕季暖蜻思阁述企休更议掌蓄嫩石引扎亲乒锅娘服美巡扬命银牵冬但铁悼馋拐方掀根驱战胞仿配群询士挥迎剥臭泪蛋狠评熔膀践矛邀乘尺岸爸罩咳见牌糠反净硬发恐敞靠晕神阅殖泡台致死椒屡僵备炎念殿典园句百床急佣候咽滩疫兆章烛跪脚描造监宗遍匠存赠俘属荣压趣概渴咬宇稀贝学启毙感付写冠姥狡允瓦像诗路零悬内洪川趁识厘释拦搁帜册过玉患灯野浊乱常恶摧免茧懂勾堂称淋烫披挨捆淡津妖仰六掉眠闲耗跳匙涌赶基傻羡凤问个试焦劈锋醒棉哲了云骗帖轧舱洽刀达仁摸所拢滨镜固哀税祖袖顾沿渡糕河中立耻柿勇胖规龟晒坊割电迹售干姿渗面谷膜胆瓣淘伞孟爽衫矮宽粱义魔父吼尿华壳真族廊长纤月跃显裙撕汽凭何础越北跟叶主哪争印伪须溪求愁正衰闸际库柴疯看虹攻衬还驶姨酿师茶锹抗胀丧罗则针逆斥亮体宅淹优粪厨森杏抄握泊料通芬渔杀奖抬隔蝶塘鸦顺烧毒奏瓜社窑纹睬歇范仔截辆状旬帐添锄置竿嫌慌舅坑否熟撒说谊拆纪睛职和异水尽麦榨耍与深殊婶匀搏冤维衣绒愧掠菌搞御乞整爬差团浩伴奸削翅踢缝往充障仪比喜难很换益他替伙顶滤家员总您绪从弓佩闻谢建朵续涨州骡海啊毅倡尊泼商众幅旱盈开氧弹宪律待奔展郊慰界穴绣虫嫁苏猴沙佛乙口械脆亡途赔惨王掏莲束风疗复默碗扇糊某橘横剖孤亿偶砌图胁悄翼奇封忧届贤君蔬含细突俭层儿葱裳境析嗽巧刚齐茫销具丘帝吐龄摘廉校借远为经沟分股摇捡彻夜勺蜡五委膏党输丹嘉剂克厉寸弄言竹扩秀捎力间仓刷掘蜂旷昆钓例亩豪或域捞刮朱黑架怖己蹲搂敲推诸局可壮衔于赚毛悟呢小重巴城织妹挖壁治轮帽土蛇态辛袍改秋蚂筝号课草拿囊奶呜妨实戒贷倘浅婚拒箩虎各扁畅俯果进音笔继氏连酸考坝官射怠苦穷桶倾满相指勒邪已恒子颗吵龙步乏辟剪布意肤院奋京苍膊吓斗夫严弟运铸户绕阴邻宋扣灿忆蓝伶太谋刘梯刑词炕犬堵另艘恰痒叙缴咸洗扮虏馆颂办唯匆峡罢贼锤贱剑查钟痛糟极旅棋腹并全救业柄型仅部军毁有前省场折絮护秧眼萌目均劝凯肝蛙酒荡寨外饿贯窄早扫遣唉储怀励爱晌炭坦拌蔑瓶饼尼轻者稳若钻育厕鉴务寻浴鹿阻作惰秩杰蚀逢卷陶生饮协米燃理率庆筐敢恨盼需杨绩睡玻予捷以矿值斤映穿牺店管筹器肾善离叛较霉产狼串枝限籍检刃程鼠裂边迫鄙吞撞浆讽节沾游呈擦鲁盒脂断容虑垦逼霜加雪壤灭螺贸使逝纠赵庄牧贩着药伏叔速心表撤绵倍妻渣妥羊狗拍既购温及慕挡蛾拜静辩悔缘坛征款门矩薪西趟讯罐侨络抱臂墓挪垃花酱碰插姜惠桌贿驼猾志浓荐阿女乐徒舞曾骑梦奥智伐物忠湖巨霸绢陈删弦背察娇希良脱惜适喇努博崖郑母工困朴挎走话谁扔国剧拥猛波吩禁枣赤热袄旺苗鸟灶才凝接醋闯晋都申聋饭吸煌府街颠馅在丰序守茂选蚁炸慈潜踩墨旋拴材郎珍煎滔肯慎牲钱食预恋呼悠解底倦乳骄谎由似货是礼腰锈炒润斧堤七鱼模病杂同槽叨软示性影梢次今暴揭笛雕饱蔽肿享拔趋空秃击介茅这迷共哄二估丝绞效肺愤饺禽偷阵无先恢秒萝卵笑后抢漏蠢尖盏圣蹈攀锡丑锐败鹅数核血至欺番残之叼民级平径咐匹唤到阀芳桂腾揪踪屋锻男精现敌向妄跑缓漫递楚潮拘合文友算亚胶纱祝站沸遗彩辽码想准涛凉覆忌财券导键昨就颈吉徐膛洋互医漠帆舌观妈避躁槐把负减孔绿名授品盯牢欲吃隐首变肩怜琴术退哨暮缩桐饲肚木易些羽诊盾流央葬福喉寿腥钩驻杜冰划疏喂箱眉带武崇李洞骂决朋稻犁味捉雨铜秤烤论辱丙澡村历脾德县盖助脑左那粥忙岔叫油林栋参沃骤山融锦误你摩薄梅乌应鞠拣恭劲圆竭弃溜罚唱冈涝幼聪时垂赌采功皱下虚明桨皇居只兄多柜捐听式公沈纲紧旁牙赏寺纵菜填系距史巩贡量蛮刺磨迟租补标列拖框象烟危戏勉艳猎冷卧谈俱兽钳坚惑堆凑荷敬浑愿鲜度伸伤孩旧滴她傍洒语终胸婆树堪碌渐碧画养尸新甲革鼻垫吗酬粉让必昏们杯三膨冻要田驳训桃慢人受票趴筛装裕撇记惭抵摊植段讲手挤托累暗赖转窜去结铅塌汁祸铲遇任镰躲网倒泛犯航钉再审搬我嫂蚕幸餐谦焰宫盲按近阔循颤狸蕉庸浮钢恼逮饶梨培杆咱抖誉斜块质膝废厅井慨除未裁哥炉挣彼胜瘦缠献信告袭棒竟类包翻偏翁诱宣狭角仇敏辫虽汗乖微玩题液踏盟播懒符樱址杠拼刻闷绳搅顷烦得勿孙甩订约警农芹乓放忍榆沫鸽皂叹稠化仆日泳汪灾线承谣泄晚扛构责雾芦违滑朝页篮视因欧塔璃脸活旦兰侮大读低歼娃眯遭驾陪唐锣兴知顿屿僚岁茄息箭磁交芽犹乡卜凳歪隙期代耽访苹雀冒蝇卡半丢仗姐宙泉灌唇蹄客夺桥逃译积涉嘴年辞辈盗酷艺貌碍谨而故司凡疮括荒宝绑头狂收此垒迁纷俗星葵窃斯济喊挠棍叉脏详认屑利逗爹几劣副份韵笼泻坡依习聚佳妙延僻蒸轨蓬案援鞋返厂激假室湾验欣威殃艰车密埋清蛛愈煤入挽旗剩赛尾飞贴始贞哗剃宏著控耀眨舍当迅混耐陷尚惩臣涂鞭陕拉如右筋胳惧然送瑞般菠稼却浪辜肆肃炮歉足召燥它青捧块昏灰秩贸拴虫妈泥复争合遮捎还挺绑阿野早故朗哗逝样打决封蚀睬蛙胸毅全一容命交掩糟骡拆判鸭贿叫角蜻克舅肌蔽央牧珠整优盼愧友弦挨习宽锤趟没宿狂剖绩厌烘赤甩美挂弱燥丘要遭牺定帖匹隔鞋读私寿影梢生跌饥桑套损兰副告哑炼惹兵堆割腹罢毫惭煎融胶严璃牵僚劈锈富府陶织电洪悟抽占颈偏装教伸了袍艺拥撒误杆请治啦傍纠南葡钞江骗写朴凭蠢泉师集仓趁猛立技批折伞加信母忙廊菊灶渡胆袭餐疗茅洽丑勺辽栗刑尘阶游徒疼味木举湿杀床沫眉锣成汤梳求辱长话康缩框余许启毒芬火医吉审侧夸斯情计箩知碍牛排鸽祝辉壮枝峡乐冰钱狗赢异糕扑令旧节饱州乱衫凡肥股党葱剃亚蚊检臭绞磁累我匠围描需桌攻斤额端糊昨厨猾喜睛薪允怨棋懒沸钓非象来化川营执血棕锯桥曲脏宋归踩吼接绕斑笛厘搅暮客禽实务左甲孙恼隙鹊码迟熊疮亩若切都惠耕锄缸言季或管间删贵搬栽恰肯遵可田闻骂胜湖空道民领械衣姥佳步雷雕铅部花挡爪伐扬壳动搭考各敬直特甘恳凯毁稠蛛殊忽菌含派抬馅宁制饲级使杂吨盾唉鸟颤塑龙仁病横墓待栏燃攀熟行到槐丸及附司著单埋讯抹拜畏泻荣肾刷比菜忍城抢连勤肚羡帘轧嗓舍锋算货台裁樱易浇钻笑沿真边麦即赛完撑搂粗嫁泛茶满茄错别徐猴灭危墨践叛疲脸你递弄烤春兄须略您畅乎益罩偷展博适脖释冶根截院幅蔬愚瓜辨想浴挎干门对组屠短人翻棵谈如滩槽捉驻引辰芽温丝仰抚敲滥肆夏叼蛋撇逃哀贷宙拖阻摆方幕愤饶编推吓逗洞栋微籍华北楼氏肤查煮尿奶炕跪少永嘱肉喊核焦国租脑旷犹驳七拢先去葵氧表贴吩诸镇熔夫狐紫漂丧筹拍沈移障访久径讲困佩宣笋淹杠孔笨灿贱弯麻山眨洋堵骤鞭质刮袜牌候押滴队撞东月卜酿叉千叠遍垦填拘敌钉嫂坏职皆粘布右蜓跃常蕉缎番孟验耍新某停腿储泊贩搏术睡肠萍晃揉航食搁冻难懂粪厚痕量韵密缠俊恭猎巡誓办俯盗荷忆誉炎欠溉列虹胃倘哥播志尝李持丈丹虾铜第么旗伪渣断榆族纺梅曾签文妻帐奋沾二照驾捐悲碗羊渐串阀料宇尊屿随殖贼忠蝇训阅终抖诗循另躺猪炸失期战险稀飘纸票盯爸状聋喉浸斗圆伏浙跟郑这竞试涨苏裤匙注烧颜序娇狮登援丰洗苦三申荐婶矿厉颗倒负暖阵马抵袄捧工感科怖胳纷堤且垂休蹈劳旨峰渗劣凳唇被丁毛渠恒圾团小官腥才欣草预顷手世耽脆衰旦称页疏慕础个录凝宰探之子群沙咽津载就轰降字印债陆稍港廉透招林涌流致碌条势士吗隶碎尤碰俘萌逼昼缺陕膜脂坊享名添策纵渴貌父宴界齿袖功犁蒸庆症雾披活馒妙覆痒雹则堂抄酸轻篮摔至裙农能礼粱题址桨拿泼席扎驱品入案创涛乏吐只艇婚膀岩辆诊思剪钳为谎娱倡旱俭演浓晓设乞潮孝崭惑怠点绪粮备浪钥植帜掉很铃纪望确黎莫眠撕做担压寄精贫迷依哭葛醋砌周共晌疑率见层稼膏是晕违肝臣窜秧昌纯漆太娘闷半狠咐调再晶程泳心沟害宫承养亭抓系越矩柿居皇岂寒歼里怒勒针四说朋善欲零于书介收榨米音柴妥型薄帅片幸以晋蹦几宾拐予衬窗逮芒尸大锦呆稻责摩瞎殿售牙谱囊得遥虎叮军元报井拦纳歪政金悼阔类浆侮默岗景百俗必夜厕窃限挠茂勾嫌滑露清订郎防互削却恶畜罚锁奇酱运市锅毙溪神闭仔铲偿厂壁杏扶饮虚秋岛石劝今支不前棉联肺按析朵奸补吊酷悠绸君获鹅相警柳模双谋足饭号剥瞒猜皮纽园伴保枯裹换章鸡酬好冠蝴袋度庭液王椒牢年际谢刀机版慰倍绿从返熄悦仍强胀岁秀硬典姻采奔卷些轮蔑谅悄威壤详陪擦抗维杨跨绳赔刺腐索形朽垃观驰邪扁气躬蚕红资猫椅骨效烦躲权广伙坦苗朝焰充柔软旁古蹄祖屈后乔稳们宵矛授糖蓬评放疤赏种龟柄谁螺逢般育顽堡恨歌仗腊更稿彼已败励携侦规他员费飞站枕肃币裕进最烟现她往受桃和细冲划语破弟络顿导区达弹闲豆献奉刚键谣像册己捕抛锡果碑目呈艳日吞闯屑筋赞竖财校瘦据挖扣式择痛勿词款惨有冤疫冷愿渔恢瓣赚帝应迎赖法诚快促鼠萝地膨视纤色球销造翠艘寸拔摄柱扩铁冬估配砖敢箱追泪剧箭超缝替出顾绍智剂姐盟忘忧闹厦浑牲穴邮本鱼姑赴用脚尼监公晴垮增论皂助舒示尚普利拾晒原吧亲饼价狱催咱绝呼画齐禁驴臂口良时场店吹仿夕歇巴嚷传巩卖青经竟窝旋垄棚五穷啄退脱怀盖邀酒谨敞香格局提蹲戚征听涉既筑爷哈振识库在云茎琴扯健答凤恩背揪扒刊包修会改扮体郊恐松秤醉僵声丽底而它向企唐消括税陈链亮胡妄阴唤奴位途弊洒垒暴溜船翅安班车甜性饿翼凑亏基奏靠哪怜胖迈蛮银圣滔油漫迫继眯议鹰坝烈河吸兆坡董留芹祸膝拌眼哨隐玻除灾磨止回叔贝雄醒究插鼓淘珍桂狡历输晨疆浅帽似尖筝远然距假看卸否多滤蜘握态腔六学无雀慧染业辜劫罐敏揭京昂聪辫变首女响内彻商通续概乃顶冒榴鉴呜低乖皱简家陡所扛寨毯协讽喘叹叙锐环伤遗瓦房慨梁爽滨未禾那愁罪姨怪舰束源怕西竿谊转跑届控翁恋聚延砍缴掀饺忌鹿汗勇挪网咳图光耀吃乓脾路娃男愉谦骑苹着婆涂让自搜升速落润叶券但哲纲绵贤冈斧呢素弓狸关妨缓下段遇侍鼻炊膊笼诉暗雪喇厅选塘浊送馋弃由惧羞赵档高走赠属力芳巧鄙脉线艰钢住上赶罗趋邻十肩姓妹钟水挥准迁避积挣乌该摘葬瑞捷睁德免射汽坐紧死吵符伶侨解浩丢什庄岸息召滚供革览辩馆蚂彩糠托狼操缘绢傅勉午宪魔坑乙刘爬匆培壶件悔毕护与兼霉迅筒宗蒜屯述惩搞淋摇秆突开减讨散篇踪兽武绒况御骄宝枣丙玩崇雁昆总怎诞者唱仆盆杯任僻反歉找盛净苍豪汪慢坚谷胞拣始主俊该驰拾恩漂刊煮纺九伍找港证周计捕欠呀岛万腐谱棚完肉做讨制歌嚼地嘱错保夏押登东怨催两处爪能蒙链住栏端栽权组痕偿昼笨宵耳甘市榴且猫钞轰弯麻粒供愚肢池起本况鸭姑蚊批买绝用兼占摔不吴少散短穗火珠雄拨昌烘腊陆抓快欢浇盆梁朽熊柏丁稿宾降气别船屠悲枕柔照袜种狐捏脉筑姻会隆抽疲岭巾策景坟贺操甜举锯畜丽橡围势孕振设饰档里富择喷样奴衡贫遥拳葡疾岂切症勤升哈屯摆毯豆鬼莫虾雷辰防摄肠脖厚啦蝴紫竞冲尘创招尝究响千版确皆傲侍露禾单晨额尤侦上岩打执赢晓源俩健阶悉缺邮倚投劫鼓狮夸湿滥壶渠宁据斩碎凶闹帮雅位烂榜取迈粮铃给消便糖侧镇毫呆锁辨行支房队雹裹柱搜损盘钥乎事辉亏毕黎集金落高独坏帅第惹寄燕判营闪扯卖扭专堡灰艇兵瞧好自夹黄芝排驴一又令调扑孝震白留抹牛丈隶棕最胡翠什甚绍顽亭费纸香厦领祥件出篇熄吧喘秆价卫痰染梳卸绸娱嚷浙咏增纽泰遮附蒜传双透桑炊逐罪稍夕关沉移溉也联腿币特醉爆怒直薯南寒谅忘惯惊嗓吨蜜末害粗宰强葛猜老环晃冶芒吹赞魂光区坐哑汤藏晴跨签漆施泽松安童绘洲修灵鹊竖请叮袋垄亦誓舰栗诞素编傅仍声持班峰随江瞎临注塑滋炼霞泥粘滚久秘挑将弱污债魄圈丛楼圾烈雁撑古猪骆缸春萍诉盛丸诚乃蜘浸碑耕株椅来成张动骨舒套爷砍哭昂破啄吊揉马辣繁阳瞒扶广八等诵红曲斑睁飘菊役蜓奉枯伟垮觉疼色形姓胃纯妇抛对派跌字点触略笋板羞匪每";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        int res = newsService.create(news);
        assertTrue(res > 0);
    }

    @Test
    public void IT_TD_003_002_001_010() {
        int id = 1;
        String title = "";
        String content = "展夏绢叫激踩遍唤坑谜眼梯宰盐艳炕最碎蜓梳饰造惰丘息记槐储囊纪膏职井整铅遣戚幕外辛魄所苦坏忍汪偷微扑恨染境骑炮籍住灯锣摊天缓捐环执纵降瓣轿狱歉滴月拢兆渐粪组胸桥悔驳秃仿店声商断阵赵暴员慨喇拆氏榨建扮著给您嗓始惑零霜卖鞭点屋炸灰跨善甚池埋恢仇派妥方早奶手脖敌段恒菜诊嫁盗排惠素闯调择进撞割亦爸串窗飞叼剧较穗叙净粥都庭感牙浙字纽虚谱蛾虫集狐婶南钞膊劲便旷捉拌奇萌英揉欲毙骗痒陆绞书疆冲免映他于蹦虾者尖遇仆册遵谋柳矿妻票窄总狼缸值姜纤秤绍锤望适表碑扎厚聚附篮肩嚼孤愁言颤替偿尼梢披蹈汁才捞叔尸爷钩身扛获物询王浪诗侄谁跳液威竖此秋横先郊榴曾惧区切鸡诚讯疼陪床劳处裳闲充时效毛踏燕茶贩闭胜量伪耗桨睛梅雁聪密殿叹袜维扁漫件谈饿吃麻婆仰张偶模趁畏旨歌介帘奖钳灵雕宏抱研吴围纳掘高企专棍扭咏垄菠教忧玩掉什滚丽厌又胃超咐扶滤勺压匹鞠纯宵饺肯清沸永波还孟朗阴弹洪苗庄午宗衰盈么色斩旦浸邮犬站摸茂改森左迹掌奸步填驱增姓觉璃仗跑返妖扯索那岗丸绩斤垮理枕肆待菌蝇鼓赖挺若立据洋谎诉辣脏仙一俩硬斧远彻悟药要铜尺等起陶勿糊毫证畜晌逮牛撇护锁人驴芒昨寻亭像赛唯浇短抗饥洗器歪样罐协钉骡丑界金肥尚泡重挽鸟腹空送匠寨厉葵粘绒祝局锻西勤删渡县挠碧衔德栏炒形个幼友拒迁航里驼鸭祸税绵厕嚷台辰凯熊辉纷蚕涛淋缺亲喊接窜眉荣舌全堵羞乡屯骨何找乘松传祖烫爬业泽凑隔醉指臂容测宴惕洒号初功泥梦荷踪田旱华恩莫淡克和消杯污玉土课萝角谅喝盒蔽近问房悠诸习序汗其丛济悉腔郑笛宁凳努狮管猴顷鸣哲巡僵发迅世夸樱傅孝贷雪股做恼脊份吐劝搬通姥距鉴焦潜贿乱藏梨完掏广栽辫涝棋邻题损头弱木是违懂戒哨轰缘劫拾带宫赔登闹筛忌睬挎孙论粱制暗厦提句亮很洲科削竿肢斗忆历云哭级窃苍勾丢用挣概夜针杜柜培夕省龙倾沉少铺齿牌垂庸址俱咸拜卸的弦卷阻戴跪中匙花成宾资宜赌懒狸绳杏豆而语荒武被轮岔服耽雨抚侮冤葛仅慎五太摧橘薄慕瘦泰百蒸豪灭轧滔几斜支半涨般讽惹帐兵怜录慌秆相哑伙划尊怕女萄煤舞蛮哥情写浆端辅芳禾驻抖亡龟献虽固机灿咬婚杠俭席基酷均栋如俊丈上底酬隆堡肾稀说蒜阁青套格叛直兽奥圈国六元臭不筒煌晒春享笑挪恭约亿咳傻虑祥粒柱疯宇防枪盯倦帽事例岩疗寸使持刷岛海鄙础棉从杰保试征傍把熟战孩帝融鸦宽抵沾嫂翼宅故晓反呈己该奔难孔纹泻缝港颂甜浴收坊租趣拿伟裤碗龄央塌漏券签油瞧详引否即比蒙版实林授岁闷限呢盛煎慈砌愚屡条影迟舅扬尾蠢默矩俘剂及陕鼠凶行出领怠甩认非君楼景沃蓬脂规窑醋崖胳察叮火陵码市锯眠贤冶供吼炊害了四宝痛碰翅御桂脆修陈刻躲撤惜秩布塘锅斑颠博姿乒公既旺仍兰赏抓泊膀趴乙渴城置惊扒态谢萍货率悄我常愧饶寿夺架另喂傲页佣些援盼撒守冬订谣敞岂晕图泛疮妙械决溜饮肚算润更评咽诞卫姑剖岭本捷皱酿鸽新郎敬军肝着艰墓搅知计旗矛父笨驶锈啊佳屈礼皮弟娃马乳砖似日僚棕廉叉炭困惯李冈标化厨铲堆袋意瑞桑势磨伞弊党析创抢们亩虹饼绘哗村尿巷阿逝灌堤珠她浅谷吸寄怒泉乖弃洞养社状式役倍落锄妹耕蛇占砍缎危绸疑筑猫霉扩兔由牧二简穷举兄奏杂矮球办鹰遥文覆吹毒向插采吩七塑催疤借康秀浑抛述蛋芬秧箱香十承益株策夫膜丹树侵欺睡狗责叠兴嘉与背层河种避瞎赠严付圾浮荐溉烟性震材食坛汽胞求吵贫爆趟稼愤蓄自督壮某擦徒渔巾并肠痰挨抄筋神肺槽誉案喷莲膛衬居恰刀庆升袭肉铸庙网忠坟饭熔译备蚁疾骆芦稳双导看阅咱隶程昼括妈彩乞烧齐以描别舍含递臣死年剪搂淘告搭宋捧葱邀榜识蜜换盟绣绕腿姨岸筐截拣万关渣驰剩隙钱慧封债朋面必胆匆缠良预阳料列蛛蜂粮迫部盘瓜希狭已挂迎明务优愈贝碍毅杀权内皆凤示满东唉运数茅铃巴八盲贼典呆侧下炉奉摔首尘况匪依伯亚伏活江舱翻漂道项气逐冒疏辽有育舟廊竭检座白错鲜斥忙愉留殖废溪娇积颜动革倘银沟悦鹿闻陷肌因加民宣钟谦洁请绪罩侦勒轻晨衫拖施你失挑入吞羊流勉冻昆巩就控骄织扫津昂漠船笋刮侨途伤病帮殃拥抹柔周垦应攻箩钓训猜焰耻却锹秒参追玻确逗寺唱脉狡健奋旅垫喜蚊杨艺燥脾只诵堂将耳垃牵梁屠拉疲尽细逼镇它躺娱猾鞋师旬丰枣茎循代须经节越售延误胀汇仔遭浩卵真屑慢按锋口渠开府衣剑委箭誓招胖车寇挤届撕逆线邪补域氧黎惨添男柴乐归姐杆蜻纱晚键吓响爹为朽丙骤佩逢倡涌休柏今竞光也翁究镜司踢交块路往欣煮疫黄会私独谊泼崭甲凭智穿顿破惩推果桐馅番赢塞任粉贸解富帜飘州稠访撑蛙膨辞墨欧赴趋灾馋斯盖壶救话档园雄冠刊移款拴缩嘴拦放纸棚握静这芝伶见忽携同快母临凉单朵炎三驾偏潮农旧暖之顺穴脑殊剥泪贴判裕志拘统桌蚂湾突恶劣续校退倒挥众大粗折场喉炼沿象呼芹吧晴准回吨蜘刑雷稿音呜怨过涂辩石耀茫肤慰螺雹互薪混客呀照够负称滨至卡核且墙幸托筝拐遮想峡敲揪歇瞒术摩额絮熄刘精定辨审厅利湖棒注桃谨让沫许苹餐乔犁栗恋纺赚福仁词唐治投遗强患予位魂笼命貌牲两跃设学睁嫌钢末妄怪度义棵担群议营但阔产搞贺糖士馒猪舰赤探柿障伴政九蕉瓶圣显迈装裙厘板史街鱼茧捕塔桶旋名弯搜贡嫩变官逃椒帖眯蚀烘链低堪肃源禁对摄甘辱纠离鲁取辈掠帆足贱构极壤美深瓦烛鬼讨库狠刃艇丝腰袄未敏蝶牺惭阶具痕尝虎滥劈恳椅跌可草戏巨葬乎然唇沙贞辟乌赶安摆朴酒靠佛膝品嘱编生允乃烈屿则主山董贯蝴宪坚答夹残蹲拳卜电结哄畅捆长法侍滩烂恐正朱皂颗停晶酱载达急罪胶啄植估京罢榆味犯霞前哀眨淹仓思醒体稻寒盆烦家际洽演伐警浓差各爱柄除珍查腥水存蓝怎印现毕欢院继古右累罚腐捎触来敢茄米雅冰讲游没径励勇躁哈普魔腊辆筹费次孕轨押倚罗刚狂锐召枝钥圆视烤随怖泳旁竟匀丧释族巧作练速俯受暮后脚分框兼捏促符蔬验汤配啦绑听力输振嗽毯束禽能胁扰羡苏抬薯击脸打壳略滑悬络型申搁涉晋颈症坝属揭绝阀陡妇彼凡财崇沈丁叨鹅钻挖类漆温软季亏虏践启目笔葡平红琴橡娘合摘哪碌繁磁副绿辜播复贵片在妨酸连歼晃聋千徐批澡奴根爽紫犹顾章第袖吊子律挡悲雾菊欠星俗糕悼燃锡盾止跟联楚昌骂当户爪走耐掀裹饱窝隐幅宿减帅每耍透需购蹄韵姻湿血包去助紧艘系喘川报衡币扣共闪霸铁览团得拼儿抽北坦伍渗剃技班刺忘期质猎皇好扔糠鼻峰险麦贪牢风卧观叶迷镰闸暑朝操范秘僻露念童缴令工裁愿浊室队多袍稍小散假顽特老灶间荡再诱摇监枯尤赞价鹊拍野久吉肿黑冷捡转地致顶无候易糟垒仪盏坡凝吗销边热买搏坐蔑弄读饲芽攀终异信裂原幻厂躬脱壁锦乓蜡竹败猛射雀昏腾拨或掩宙汉画门纲毁拔乏暂泄滋羽伸篇考干选弓扇舒馆医争余到心怀曲胡翠展夏绢叫激踩遍唤坑谜眼梯宰盐艳炕最碎蜓梳饰造惰丘息记槐储囊纪膏职井整铅遣戚幕外辛魄所苦坏忍汪偷微扑恨染境骑炮籍住灯锣摊天缓捐环执纵降瓣轿狱歉滴月拢兆渐粪组胸桥悔驳秃仿店声商断阵赵暴员慨喇拆氏榨建扮著给您嗓始惑零霜卖鞭点屋炸灰跨善甚池埋恢仇派妥方早奶手脖敌段恒菜诊嫁盗排惠素闯调择进撞割亦爸串窗飞叼剧较穗叙净粥都庭感牙浙字纽虚谱蛾虫集狐婶南钞膊劲便旷捉拌奇萌英揉欲毙骗痒陆绞书疆冲免映他于蹦虾者尖遇仆册遵谋柳矿妻票窄总狼缸值姜纤秤绍锤望适表碑扎厚聚附篮肩嚼孤愁言颤替偿尼梢披蹈汁才捞叔尸爷钩身扛获物询王浪诗侄谁跳液威竖此秋横先郊榴曾惧区切鸡诚讯疼陪床劳处裳闲充时效毛踏燕茶贩闭胜量伪耗桨睛梅雁聪密殿叹袜维扁漫件谈饿吃麻婆仰张偶模趁畏旨歌介帘奖钳灵雕宏抱研吴围纳掘高企专棍扭咏垄菠教忧玩掉什滚丽厌又胃超咐扶滤勺压匹鞠纯宵饺肯清沸永波还孟朗阴弹洪苗庄午宗衰盈么色斩旦浸邮犬站摸茂改森左迹掌奸步填驱增姓觉璃仗跑返妖扯索那岗丸绩斤垮理枕肆待菌蝇鼓赖挺若立据洋谎诉辣脏仙一俩硬斧远彻悟药要铜尺等起陶勿糊毫证畜晌逮牛撇护锁人驴芒昨寻亭像赛唯浇短抗饥洗器歪样罐协钉骡丑界金肥尚泡重挽鸟腹空送匠寨厉葵粘绒祝局锻西勤删渡县挠碧衔德栏炒形个幼友拒迁航里驼鸭祸税绵厕嚷台辰凯熊辉纷蚕涛淋缺亲喊接窜眉荣舌全堵羞乡屯骨何找乘松传祖烫爬业泽凑隔醉指臂容测宴惕洒号初功泥梦荷踪田旱华恩莫淡克和消杯污玉土课萝角谅喝盒蔽近问房悠诸习序汗其丛济悉腔郑笛宁凳努狮管猴顷鸣哲巡僵发迅世夸樱傅孝贷雪股做恼脊份吐劝搬通姥距鉴焦潜贿乱藏梨完掏广栽辫涝棋邻题损头弱木是违懂戒哨轰缘劫拾带宫赔登闹筛忌睬挎孙论粱制暗厦提句亮很洲科削竿肢斗忆历云哭级窃苍勾丢用挣概夜针杜柜培夕省龙倾沉少铺齿牌垂庸址俱咸拜卸的弦卷阻戴跪中匙花成宾资宜赌懒狸绳杏豆而语荒武被轮岔服耽雨抚侮冤葛仅慎五太摧橘薄慕瘦泰百蒸豪灭轧滔几斜支半涨般讽惹帐兵怜录慌秆相哑伙划尊怕女萄煤舞蛮哥情写浆端辅芳禾驻抖亡龟献虽固机灿咬婚杠俭席基酷均栋如俊丈上底酬隆堡肾稀说蒜阁青套格叛直兽奥圈国六元臭不筒煌晒春享笑挪恭约亿咳傻虑祥粒柱疯宇防枪盯倦帽事例岩疗寸使持刷岛海鄙础棉从杰保试征傍把熟战孩帝融鸦宽抵沾嫂翼宅故晓反呈己该奔难孔纹泻缝港颂甜浴收坊租趣拿伟裤碗龄央塌漏券签油瞧详引否即比蒙版实林授岁闷限呢盛煎慈砌愚屡条影迟舅扬尾蠢默矩俘剂及陕鼠凶行出领怠甩认非君楼景沃蓬脂规窑醋崖胳察叮火陵码市锯眠贤冶供吼炊害了四宝痛碰翅御桂脆修陈刻躲撤惜秩布塘锅斑颠博姿乒公既旺仍兰赏抓泊膀趴乙渴城置惊扒态谢萍货率悄我常愧饶寿夺架另喂傲页佣些援盼撒守冬订谣敞岂晕图泛疮妙械决溜饮肚算润更评咽诞卫姑剖岭本捷皱酿鸽新郎敬军肝着艰墓搅知计旗矛父笨驶锈啊佳屈礼皮弟娃马乳砖似日僚棕廉叉炭困惯李冈标化厨铲堆袋意瑞桑势磨伞弊党析创抢们亩虹饼绘哗村尿巷阿逝灌堤珠她浅谷吸寄怒泉乖弃洞养社状式役倍落锄妹耕蛇占砍缎危绸疑筑猫霉扩兔由牧二简穷举兄奏杂矮球办鹰遥文覆吹毒向插采吩七塑催疤借康秀浑抛述蛋芬秧箱香十承益株策夫膜丹树侵欺睡狗责叠兴嘉与背层河种避瞎赠严付圾浮荐溉烟性震材食坛汽胞求吵贫爆趟稼愤蓄自督壮某擦徒渔巾并肠痰挨抄筋神肺槽誉案喷莲膛衬居恰刀庆升袭肉铸庙网忠坟饭熔译备蚁疾骆芦稳双导看阅咱隶程昼括妈彩乞烧齐以描别舍含递臣死年剪搂淘告搭宋捧葱邀榜识蜜换盟绣绕腿姨岸筐截拣万关渣驰剩隙钱慧封债朋面必胆匆缠良预阳料列蛛蜂粮迫部盘瓜希狭已挂迎明务优愈贝碍毅杀权内皆凤示满东唉运数茅铃巴八盲贼典呆侧下炉奉摔首尘况匪依伯亚伏活江舱翻漂道项气逐冒疏辽有育舟廊竭检座白错鲜斥忙愉留殖废溪娇积颜动革倘银沟悦鹿闻陷肌因加民宣钟谦洁请绪罩侦勒轻晨衫拖施你失挑入吞羊流勉冻昆巩就控骄织扫津昂漠船笋刮侨途伤病帮殃拥抹柔周垦应攻箩钓训猜焰耻却锹秒参追玻确逗寺唱脉狡健奋旅垫喜蚊杨艺燥脾只诵堂将耳垃牵梁屠拉疲尽细逼镇它躺娱猾鞋师旬丰枣茎循代须经节越售延误胀汇仔遭浩卵真屑慢按锋口渠开府衣剑委箭誓招胖车寇挤届撕逆线邪补域氧黎惨添男柴乐归姐杆蜻纱晚键吓响爹为朽丙骤佩逢倡涌休柏今竞光也翁究镜司踢交块路往欣煮疫黄会私独谊泼崭甲凭智穿顿破惩推果桐馅番赢塞任粉贸解富帜飘州稠访撑蛙膨辞墨欧赴趋灾馋斯盖壶救话档园雄冠刊移款拴缩嘴拦放纸棚握静这芝伶见忽携同快母临凉单朵炎三驾偏潮农旧暖之顺穴脑殊剥泪贴判裕志拘统桌蚂湾突恶劣续校退倒挥众大粗折场喉炼沿象呼芹吧晴准回吨蜘刑雷稿音呜怨过涂辩石耀茫肤慰螺雹互薪混客呀照够负称滨至卡核且墙幸托筝拐遮想峡敲揪歇瞒术摩额絮熄刘精定辨审厅利湖棒注桃谨让沫许苹餐乔犁栗恋纺赚福仁词唐治投遗强患予位魂笼命貌牲两跃设学睁嫌钢末妄怪度义棵担群议营但阔产搞贺糖士馒猪舰赤探柿障伴政九蕉瓶圣显迈装裙厘板史街鱼茧捕塔桶旋名弯搜贡嫩变官逃椒帖眯蚀烘链低堪肃源禁对摄甘辱纠离鲁取辈掠帆足贱构极壤美深瓦烛鬼讨库狠刃艇丝腰袄未敏蝶牺惭阶具痕尝虎滥劈恳椅跌可草戏巨葬乎然唇沙贞辟乌赶安摆朴酒靠佛膝品嘱编生允乃烈屿则主山董贯蝴宪坚答夹残蹲拳卜电结哄畅捆长法侍滩烂恐正朱皂颗停晶酱载达急罪胶啄植估京罢榆味犯霞前哀眨淹仓思醒体稻寒盆烦家际洽演伐警浓差各爱柄除珍查腥水存蓝怎印现毕欢院继古右累罚腐捎触来敢茄米雅冰讲游没径励勇躁哈普魔腊辆筹费次孕轨押倚罗刚狂锐召枝钥圆视烤随怖泳旁竟匀丧释族巧作练速俯受暮后脚分框兼捏促符蔬验汤配啦绑听力输振嗽毯束禽能胁扰羡苏抬薯击脸打壳略滑悬络型申搁涉晋颈症坝属揭绝阀陡妇彼凡财崇沈丁叨鹅钻挖类漆温软季亏虏践启目笔葡平红琴橡娘合摘哪碌繁磁副绿辜播复贵片在妨酸连歼晃聋千徐批澡奴根爽紫犹顾章第袖吊子律挡悲雾菊欠星俗糕悼燃锡盾止跟联楚昌骂当户爪走耐掀裹饱窝隐幅宿减帅每耍透需购蹄韵姻湿血包去助紧艘系喘川报衡币扣共闪霸铁览团得拼儿抽北坦伍渗剃技班刺忘期质猎皇好扔糠鼻峰险麦贪牢风卧观叶迷镰闸暑朝操范秘僻露念童缴令工裁愿浊室队多袍稍小散假顽特老灶间荡再诱摇监枯尤赞价鹊拍野久吉肿黑冷捡转地致顶无候易糟垒仪盏坡凝吗销边热买搏坐蔑弄读饲芽攀终异信裂原幻厂躬脱壁锦乓蜡竹败猛射雀昏腾拨或掩宙汉画门纲毁拔乏暂泄滋羽伸篇考干选弓扇舒馆医争余到心怀曲胡翠";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        int res = newsService.create(news);
        assertTrue(res > 0);
    }

    @Test
    public void IT_TD_003_002_001_011() {
        int id = 1;
        String title = "";
        String content = "展夏绢叫激踩遍唤坑谜你眼梯宰盐艳炕最碎蜓梳饰造惰丘息记槐储囊纪膏职井整铅遣戚幕外辛魄所苦坏忍汪偷微扑恨染境骑炮籍住灯锣摊天缓捐环执纵降瓣轿狱歉滴月拢兆渐粪组胸桥悔驳秃仿店声商断阵赵暴员慨喇拆氏榨建扮著给您嗓始惑零霜卖鞭点屋炸灰跨善甚池埋恢仇派妥方早奶手脖敌段恒菜诊嫁盗排惠素闯调择进撞割亦爸串窗飞叼剧较穗叙净粥都庭感牙浙字纽虚谱蛾虫集狐婶南钞膊劲便旷捉拌奇萌英揉欲毙骗痒陆绞书疆冲免映他于蹦虾者尖遇仆册遵谋柳矿妻票窄总狼缸值姜纤秤绍锤望适表碑扎厚聚附篮肩嚼孤愁言颤替偿尼梢披蹈汁才捞叔尸爷钩身扛获物询王浪诗侄谁跳液威竖此秋横先郊榴曾惧区切鸡诚讯疼陪床劳处裳闲充时效毛踏燕茶贩闭胜量伪耗桨睛梅雁聪密殿叹袜维扁漫件谈饿吃麻婆仰张偶模趁畏旨歌介帘奖钳灵雕宏抱研吴围纳掘高企专棍扭咏垄菠教忧玩掉什滚丽厌又胃超咐扶滤勺压匹鞠纯宵饺肯清沸永波还孟朗阴弹洪苗庄午宗衰盈么色斩旦浸邮犬站摸茂改森左迹掌奸步填驱增姓觉璃仗跑返妖扯索那岗丸绩斤垮理枕肆待菌蝇鼓赖挺若立据洋谎诉辣脏仙一俩硬斧远彻悟药要铜尺等起陶勿糊毫证畜晌逮牛撇护锁人驴芒昨寻亭像赛唯浇短抗饥洗器歪样罐协钉骡丑界金肥尚泡重挽鸟腹空送匠寨厉葵粘绒祝局锻西勤删渡县挠碧衔德栏炒形个幼友拒迁航里驼鸭祸税绵厕嚷台辰凯熊辉纷蚕涛淋缺亲喊接窜眉荣舌全堵羞乡屯骨何找乘松传祖烫爬业泽凑隔醉指臂容测宴惕洒号初功泥梦荷踪田旱华恩莫淡克和消杯污玉土课萝角谅喝盒蔽近问房悠诸习序汗其丛济悉腔郑笛宁凳努狮管猴顷鸣哲巡僵发迅世夸樱傅孝贷雪股做恼脊份吐劝搬通姥距鉴焦潜贿乱藏梨完掏广栽辫涝棋邻题损头弱木是违懂戒哨轰缘劫拾带宫赔登闹筛忌睬挎孙论粱制暗厦提句亮很洲科削竿肢斗忆历云哭级窃苍勾丢用挣概夜针杜柜培夕省龙倾沉少铺齿牌垂庸址俱咸拜卸的弦卷阻戴跪中匙花成宾资宜赌懒狸绳杏豆而语荒武被轮岔服耽雨抚侮冤葛仅慎五太摧橘薄慕瘦泰百蒸豪灭轧滔几斜支半涨般讽惹帐兵怜录慌秆相哑伙划尊怕女萄煤舞蛮哥情写浆端辅芳禾驻抖亡龟献虽固机灿咬婚杠俭席基酷均栋如俊丈上底酬隆堡肾稀说蒜阁青套格叛直兽奥圈国六元臭不筒煌晒春享笑挪恭约亿咳傻虑祥粒柱疯宇防枪盯倦帽事例岩疗寸使持刷岛海鄙础棉从杰保试征傍把熟战孩帝融鸦宽抵沾嫂翼宅故晓反呈己该奔难孔纹泻缝港颂甜浴收坊租趣拿伟裤碗龄央塌漏券签油瞧详引否即比蒙版实林授岁闷限呢盛煎慈砌愚屡条影迟舅扬尾蠢默矩俘剂及陕鼠凶行出领怠甩认非君楼景沃蓬脂规窑醋崖胳察叮火陵码市锯眠贤冶供吼炊害了四宝痛碰翅御桂脆修陈刻躲撤惜秩布塘锅斑颠博姿乒公既旺仍兰赏抓泊膀趴乙渴城置惊扒态谢萍货率悄我常愧饶寿夺架另喂傲页佣些援盼撒守冬订谣敞岂晕图泛疮妙械决溜饮肚算润更评咽诞卫姑剖岭本捷皱酿鸽新郎敬军肝着艰墓搅知计旗矛父笨驶锈啊佳屈礼皮弟娃马乳砖似日僚棕廉叉炭困惯李冈标化厨铲堆袋意瑞桑势磨伞弊党析创抢们亩虹饼绘哗村尿巷阿逝灌堤珠她浅谷吸寄怒泉乖弃洞养社状式役倍落锄妹耕蛇占砍缎危绸疑筑猫霉扩兔由牧二简穷举兄奏杂矮球办鹰遥文覆吹毒向插采吩七塑催疤借康秀浑抛述蛋芬秧箱香十承益株策夫膜丹树侵欺睡狗责叠兴嘉与背层河种避瞎赠严付圾浮荐溉烟性震材食坛汽胞求吵贫爆趟稼愤蓄自督壮某擦徒渔巾并肠痰挨抄筋神肺槽誉案喷莲膛衬居恰刀庆升袭肉铸庙网忠坟饭熔译备蚁疾骆芦稳双导看阅咱隶程昼括妈彩乞烧齐以描别舍含递臣死年剪搂淘告搭宋捧葱邀榜识蜜换盟绣绕腿姨岸筐截拣万关渣驰剩隙钱慧封债朋面必胆匆缠良预阳料列蛛蜂粮迫部盘瓜希狭已挂迎明务优愈贝碍毅杀权内皆凤示满东唉运数茅铃巴八盲贼典呆侧下炉奉摔首尘况匪依伯亚伏活江舱翻漂道项气逐冒疏辽有育舟廊竭检座白错鲜斥忙愉留殖废溪娇积颜动革倘银沟悦鹿闻陷肌因加民宣钟谦洁请绪罩侦勒轻晨衫拖施你失挑入吞羊流勉冻昆巩就控骄织扫津昂漠船笋刮侨途伤病帮殃拥抹柔周垦应攻箩钓训猜焰耻却锹秒参追玻确逗寺唱脉狡健奋旅垫喜蚊杨艺燥脾只诵堂将耳垃牵梁屠拉疲尽细逼镇它躺娱猾鞋师旬丰枣茎循代须经节越售延误胀汇仔遭浩卵真屑慢按锋口渠开府衣剑委箭誓招胖车寇挤届撕逆线邪补域氧黎惨添男柴乐归姐杆蜻纱晚键吓响爹为朽丙骤佩逢倡涌休柏今竞光也翁究镜司踢交块路往欣煮疫黄会私独谊泼崭甲凭智穿顿破惩推果桐馅番赢塞任粉贸解富帜飘州稠访撑蛙膨辞墨欧赴趋灾馋斯盖壶救话档园雄冠刊移款拴缩嘴拦放纸棚握静这芝伶见忽携同快母临凉单朵炎三驾偏潮农旧暖之顺穴脑殊剥泪贴判裕志拘统桌蚂湾突恶劣续校退倒挥众大粗折场喉炼沿象呼芹吧晴准回吨蜘刑雷稿音呜怨过涂辩石耀茫肤慰螺雹互薪混客呀照够负称滨至卡核且墙幸托筝拐遮想峡敲揪歇瞒术摩额絮熄刘精定辨审厅利湖棒注桃谨让沫许苹餐乔犁栗恋纺赚福仁词唐治投遗强患予位魂笼命貌牲两跃设学睁嫌钢末妄怪度义棵担群议营但阔产搞贺糖士馒猪舰赤探柿障伴政九蕉瓶圣显迈装裙厘板史街鱼茧捕塔桶旋名弯搜贡嫩变官逃椒帖眯蚀烘链低堪肃源禁对摄甘辱纠离鲁取辈掠帆足贱构极壤美深瓦烛鬼讨库狠刃艇丝腰袄未敏蝶牺惭阶具痕尝虎滥劈恳椅跌可草戏巨葬乎然唇沙贞辟乌赶安摆朴酒靠佛膝品嘱编生允乃烈屿则主山董贯蝴宪坚答夹残蹲拳卜电结哄畅捆长法侍滩烂恐正朱皂颗停晶酱载达急罪胶啄植估京罢榆味犯霞前哀眨淹仓思醒体稻寒盆烦家际洽演伐警浓差各爱柄除珍查腥水存蓝怎印现毕欢院继古右累罚腐捎触来敢茄米雅冰讲游没径励勇躁哈普魔腊辆筹费次孕轨押倚罗刚狂锐召枝钥圆视烤随怖泳旁竟匀丧释族巧作练速俯受暮后脚分框兼捏促符蔬验汤配啦绑听力输振嗽毯束禽能胁扰羡苏抬薯击脸打壳略滑悬络型申搁涉晋颈症坝属揭绝阀陡妇彼凡财崇沈丁叨鹅钻挖类漆温软季亏虏践启目笔葡平红琴橡娘合摘哪碌繁磁副绿辜播复贵片在妨酸连歼晃聋千徐批澡奴根爽紫犹顾章第袖吊子律挡悲雾菊欠星俗糕悼燃锡盾止跟联楚昌骂当户爪走耐掀裹饱窝隐幅宿减帅每耍透需购蹄韵姻湿血包去助紧艘系喘川报衡币扣共闪霸铁览团得拼儿抽北坦伍渗剃技班刺忘期质猎皇好扔糠鼻峰险麦贪牢风卧观叶迷镰闸暑朝操范秘僻露念童缴令工裁愿浊室队多袍稍小散假顽特老灶间荡再诱摇监枯尤赞价鹊拍野久吉肿黑冷捡转地致顶无候易糟垒仪盏坡凝吗销边热买搏坐蔑弄读饲芽攀终异信裂原幻厂躬脱壁锦乓蜡竹败猛射雀昏腾拨或掩宙汉画门纲毁拔乏暂泄滋羽伸篇考干选弓扇舒馆医争余到心怀曲胡翠展夏绢叫激踩遍唤坑谜眼梯宰盐艳炕最碎蜓梳饰造惰丘息记槐储囊纪膏职井整铅遣戚幕外辛魄所苦坏忍汪偷微扑恨染境骑炮籍住灯锣摊天缓捐环执纵降瓣轿狱歉滴月拢兆渐粪组胸桥悔驳秃仿店声商断阵赵暴员慨喇拆氏榨建扮著给您嗓始惑零霜卖鞭点屋炸灰跨善甚池埋恢仇派妥方早奶手脖敌段恒菜诊嫁盗排惠素闯调择进撞割亦爸串窗飞叼剧较穗叙净粥都庭感牙浙字纽虚谱蛾虫集狐婶南钞膊劲便旷捉拌奇萌英揉欲毙骗痒陆绞书疆冲免映他于蹦虾者尖遇仆册遵谋柳矿妻票窄总狼缸值姜纤秤绍锤望适表碑扎厚聚附篮肩嚼孤愁言颤替偿尼梢披蹈汁才捞叔尸爷钩身扛获物询王浪诗侄谁跳液威竖此秋横先郊榴曾惧区切鸡诚讯疼陪床劳处裳闲充时效毛踏燕茶贩闭胜量伪耗桨睛梅雁聪密殿叹袜维扁漫件谈饿吃麻婆仰张偶模趁畏旨歌介帘奖钳灵雕宏抱研吴围纳掘高企专棍扭咏垄菠教忧玩掉什滚丽厌又胃超咐扶滤勺压匹鞠纯宵饺肯清沸永波还孟朗阴弹洪苗庄午宗衰盈么色斩旦浸邮犬站摸茂改森左迹掌奸步填驱增姓觉璃仗跑返妖扯索那岗丸绩斤垮理枕肆待菌蝇鼓赖挺若立据洋谎诉辣脏仙一俩硬斧远彻悟药要铜尺等起陶勿糊毫证畜晌逮牛撇护锁人驴芒昨寻亭像赛唯浇短抗饥洗器歪样罐协钉骡丑界金肥尚泡重挽鸟腹空送匠寨厉葵粘绒祝局锻西勤删渡县挠碧衔德栏炒形个幼友拒迁航里驼鸭祸税绵厕嚷台辰凯熊辉纷蚕涛淋缺亲喊接窜眉荣舌全堵羞乡屯骨何找乘松传祖烫爬业泽凑隔醉指臂容测宴惕洒号初功泥梦荷踪田旱华恩莫淡克和消杯污玉土课萝角谅喝盒蔽近问房悠诸习序汗其丛济悉腔郑笛宁凳努狮管猴顷鸣哲巡僵发迅世夸樱傅孝贷雪股做恼脊份吐劝搬通姥距鉴焦潜贿乱藏梨完掏广栽辫涝棋邻题损头弱木是违懂戒哨轰缘劫拾带宫赔登闹筛忌睬挎孙论粱制暗厦提句亮很洲科削竿肢斗忆历云哭级窃苍勾丢用挣概夜针杜柜培夕省龙倾沉少铺齿牌垂庸址俱咸拜卸的弦卷阻戴跪中匙花成宾资宜赌懒狸绳杏豆而语荒武被轮岔服耽雨抚侮冤葛仅慎五太摧橘薄慕瘦泰百蒸豪灭轧滔几斜支半涨般讽惹帐兵怜录慌秆相哑伙划尊怕女萄煤舞蛮哥情写浆端辅芳禾驻抖亡龟献虽固机灿咬婚杠俭席基酷均栋如俊丈上底酬隆堡肾稀说蒜阁青套格叛直兽奥圈国六元臭不筒煌晒春享笑挪恭约亿咳傻虑祥粒柱疯宇防枪盯倦帽事例岩疗寸使持刷岛海鄙础棉从杰保试征傍把熟战孩帝融鸦宽抵沾嫂翼宅故晓反呈己该奔难孔纹泻缝港颂甜浴收坊租趣拿伟裤碗龄央塌漏券签油瞧详引否即比蒙版实林授岁闷限呢盛煎慈砌愚屡条影迟舅扬尾蠢默矩俘剂及陕鼠凶行出领怠甩认非君楼景沃蓬脂规窑醋崖胳察叮火陵码市锯眠贤冶供吼炊害了四宝痛碰翅御桂脆修陈刻躲撤惜秩布塘锅斑颠博姿乒公既旺仍兰赏抓泊膀趴乙渴城置惊扒态谢萍货率悄我常愧饶寿夺架另喂傲页佣些援盼撒守冬订谣敞岂晕图泛疮妙械决溜饮肚算润更评咽诞卫姑剖岭本捷皱酿鸽新郎敬军肝着艰墓搅知计旗矛父笨驶锈啊佳屈礼皮弟娃马乳砖似日僚棕廉叉炭困惯李冈标化厨铲堆袋意瑞桑势磨伞弊党析创抢们亩虹饼绘哗村尿巷阿逝灌堤珠她浅谷吸寄怒泉乖弃洞养社状式役倍落锄妹耕蛇占砍缎危绸疑筑猫霉扩兔由牧二简穷举兄奏杂矮球办鹰遥文覆吹毒向插采吩七塑催疤借康秀浑抛述蛋芬秧箱香十承益株策夫膜丹树侵欺睡狗责叠兴嘉与背层河种避瞎赠严付圾浮荐溉烟性震材食坛汽胞求吵贫爆趟稼愤蓄自督壮某擦徒渔巾并肠痰挨抄筋神肺槽誉案喷莲膛衬居恰刀庆升袭肉铸庙网忠坟饭熔译备蚁疾骆芦稳双导看阅咱隶程昼括妈彩乞烧齐以描别舍含递臣死年剪搂淘告搭宋捧葱邀榜识蜜换盟绣绕腿姨岸筐截拣万关渣驰剩隙钱慧封债朋面必胆匆缠良预阳料列蛛蜂粮迫部盘瓜希狭已挂迎明务优愈贝碍毅杀权内皆凤示满东唉运数茅铃巴八盲贼典呆侧下炉奉摔首尘况匪依伯亚伏活江舱翻漂道项气逐冒疏辽有育舟廊竭检座白错鲜斥忙愉留殖废溪娇积颜动革倘银沟悦鹿闻陷肌因加民宣钟谦洁请绪罩侦勒轻晨衫拖施你失挑入吞羊流勉冻昆巩就控骄织扫津昂漠船笋刮侨途伤病帮殃拥抹柔周垦应攻箩钓训猜焰耻却锹秒参追玻确逗寺唱脉狡健奋旅垫喜蚊杨艺燥脾只诵堂将耳垃牵梁屠拉疲尽细逼镇它躺娱猾鞋师旬丰枣茎循代须经节越售延误胀汇仔遭浩卵真屑慢按锋口渠开府衣剑委箭誓招胖车寇挤届撕逆线邪补域氧黎惨添男柴乐归姐杆蜻纱晚键吓响爹为朽丙骤佩逢倡涌休柏今竞光也翁究镜司踢交块路往欣煮疫黄会私独谊泼崭甲凭智穿顿破惩推果桐馅番赢塞任粉贸解富帜飘州稠访撑蛙膨辞墨欧赴趋灾馋斯盖壶救话档园雄冠刊移款拴缩嘴拦放纸棚握静这芝伶见忽携同快母临凉单朵炎三驾偏潮农旧暖之顺穴脑殊剥泪贴判裕志拘统桌蚂湾突恶劣续校退倒挥众大粗折场喉炼沿象呼芹吧晴准回吨蜘刑雷稿音呜怨过涂辩石耀茫肤慰螺雹互薪混客呀照够负称滨至卡核且墙幸托筝拐遮想峡敲揪歇瞒术摩额絮熄刘精定辨审厅利湖棒注桃谨让沫许苹餐乔犁栗恋纺赚福仁词唐治投遗强患予位魂笼命貌牲两跃设学睁嫌钢末妄怪度义棵担群议营但阔产搞贺糖士馒猪舰赤探柿障伴政九蕉瓶圣显迈装裙厘板史街鱼茧捕塔桶旋名弯搜贡嫩变官逃椒帖眯蚀烘链低堪肃源禁对摄甘辱纠离鲁取辈掠帆足贱构极壤美深瓦烛鬼讨库狠刃艇丝腰袄未敏蝶牺惭阶具痕尝虎滥劈恳椅跌可草戏巨葬乎然唇沙贞辟乌赶安摆朴酒靠佛膝品嘱编生允乃烈屿则主山董贯蝴宪坚答夹残蹲拳卜电结哄畅捆长法侍滩烂恐正朱皂颗停晶酱载达急罪胶啄植估京罢榆味犯霞前哀眨淹仓思醒体稻寒盆烦家际洽演伐警浓差各爱柄除珍查腥水存蓝怎印现毕欢院继古右累罚腐捎触来敢茄米雅冰讲游没径励勇躁哈普魔腊辆筹费次孕轨押倚罗刚狂锐召枝钥圆视烤随怖泳旁竟匀丧释族巧作练速俯受暮后脚分框兼捏促符蔬验汤配啦绑听力输振嗽毯束禽能胁扰羡苏抬薯击脸打壳略滑悬络型申搁涉晋颈症坝属揭绝阀陡妇彼凡财崇沈丁叨鹅钻挖类漆温软季亏虏践启目笔葡平红琴橡娘合摘哪碌繁磁副绿辜播复贵片在妨酸连歼晃聋千徐批澡奴根爽紫犹顾章第袖吊子律挡悲雾菊欠星俗糕悼燃锡盾止跟联楚昌骂当户爪走耐掀裹饱窝隐幅宿减帅每耍透需购蹄韵姻湿血包去助紧艘系喘川报衡币扣共闪霸铁览团得拼儿抽北坦伍渗剃技班刺忘期质猎皇好扔糠鼻峰险麦贪牢风卧观叶迷镰闸暑朝操范秘僻露念童缴令工裁愿浊室队多袍稍小散假顽特老灶间荡再诱摇监枯尤赞价鹊拍野久吉肿黑冷捡转地致顶无候易糟垒仪盏坡凝吗销边热买搏坐蔑弄读饲芽攀终异信裂原幻厂躬脱壁锦乓蜡竹败猛射雀昏腾拨或掩宙汉画门纲毁拔乏暂泄滋羽伸篇考干选弓扇舒馆医争余到心怀曲胡翠";
        LocalDateTime ldt = LocalDateTime.now();
        News news = new News(id, title, content, ldt);
        assertThrows(RuntimeException.class,
                () -> newsService.create(news));
    }

    @Test
    public void IT_TD_003_003_001_001() {
        int id = 16;
        News res = newsService.findById(id);
        assertEquals("平台上线公告", res.getTitle());
    }

    @Test
    public void IT_TD_003_003_002_001() {
        int id = 2500;
        assertThrows(EntityNotFoundException.class,
                () -> newsService.findById(id).toString());
    }


    @Test
    public void IT_TD_003_004_001_001() {
        newsService.delById(16);
    }

    @Test
    public void IT_TD_003_004_002_001() {
        assertThrows(EmptyResultDataAccessException.class,
                () -> newsService.delById(250));
    }

}
