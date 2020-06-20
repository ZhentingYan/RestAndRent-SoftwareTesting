package com.meethere.IntegrationTest.Service;

import com.meethere.MeetHereApplication;
import com.meethere.entity.Venue;
import com.meethere.service.VenueService;
import com.mysql.cj.log.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MeetHereApplication.class)
@Transactional
public class VenueServiceTest {
    @Autowired
    private VenueService venueService;

    @Test
    void IT_TD_007_001_001_001() {
        int venueID=29;
        Venue res=venueService.findByVenueID(venueID);
        System.out.println(res.getVenueID());
        assertEquals(venueID,res.getVenueID());
    }

    @Test
    void  IT_TD_007_002_001_001() {
        int venueID=29;
        String venue_name="同济大学嘉定校区图书馆14楼1405室";
        Venue res=venueService.findByVenueName(venue_name);
        assertEquals(venueID,res.getVenueID());
        assertEquals(venue_name,res.getVenueName());
    }

    @Test
    void  IT_TD_007_002_002_001() {
        String venue_name="测试不存在场馆";
        Venue res=venueService.findByVenueName(venue_name);
        assertEquals(null,res);

    }

    @Test
    void IT_TD_007_003_001_001() {
        Pageable pageable= PageRequest.of(0,10);
        Page<Venue> res=venueService.findAll(pageable);
        assertEquals(1, res.getTotalPages());
    }

    @Test
    void IT_TD_007_004_001_001() {
        List<Venue> res=venueService.findAll();
        assertEquals(2, res.size());
    }

    @Test
    void IT_TD_007_005_001_001(){
        int venueID=1;
        String venue_name="venue";
        String description="侍骄鱼炒鄙悠丙离程捧侦轧筑树乳似援滩短易踏案普偶蜘乘烫夕博把存世倒住喝裕暂胀黎玉率悦贩定湿蝇狱混鹿水板视娘叫郑稀剃馅驻唐熔担牺享来胸引袭息版惯堵豆刺妨梨师吉请纱耽惕阻沉虏拥崖庙俭其月念耗乒驼熊扣辜绝逼孟汉村清宽酷挨悲沈椅绕法腥蜜紧伤颂九东爪胆赞答缝塘田偏悼休狸迷参尾钻悄养观愤潮鸡含蔽液愁识御泰付句哄喜赤汗崭持饱悉仪耍浑棋萝块畏催啦题感经厨峡庸剪源吧怨超裤踪贸滤艺同冰非遥司铜迈采妇瞎鼠干能弃叹英槐限狮灌弊栽强秩酿怒厌榴翠疮姓项袖余披溪缩找守凉警勾坟浓否热萌寺妈消阳抬恶柴去蚕较期从美代症舞培捏波聚应鞋弓格陪敢这佳浩蹈仁裹惨惑旬娃五江物小们逆租童沫寿辉弟寄盼习奸肥两叉姿喂击睬回班留鬼荐扶红寇瓶潜无后道次钥悬卷垂粥流会陡占嗽辽绵素莫颗巡揭灯控又像火仅窗延叛喊校趴横勿镰朽膜纵么图裙辈邻涂递戏殖排舌针蛙寸忌带营陵复载级赔返录掘骡鼻勤饮岁慨口绢询茧被吼下咱境冻家侮粮砖抽扁声聋梳哗杀看晌忧野伸劫虫插贵盏浆甘省微栏忘青任允农达逐心音独棉妄钱箭向笼输歌弄疗窝革篮站惜乌遇剑税尼井副偿威钓毛决听抵膏剥俊彻进摧扛室之烛阅怜胜辩萄怪放觉禽搂敏扎亩幕业镜姜天推胃探斗企想绣帅励按汽饲转洁资为杰多夫摊借跨酬刀犁环赵翻馆";
        int price=100;
        String picture="";
        String address="";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        int res=venueService.create(venue);
        assertTrue(res>0);
    }
    @Test
    void IT_TD_007_005_001_002(){
        int venueID=1;
        String venue_name="venue";
        String description="侍骄鱼炒鄙悠丙离程捧侦轧筑树乳似援滩短易踏案普偶蜘乘烫夕博把存世倒住喝裕暂胀黎玉率悦贩定湿蝇狱混鹿水板视娘叫郑稀剃馅驻唐熔担牺享来胸引袭息版惯堵豆刺妨梨师吉请纱耽惕阻沉虏拥崖庙俭其月念耗乒驼熊扣辜绝逼孟汉村清宽酷挨悲沈椅绕法腥蜜紧伤颂九东爪胆赞答缝塘田偏悼休狸迷参尾钻悄养观愤潮鸡含蔽液愁识御泰付句哄喜赤汗崭持饱悉仪耍浑棋萝块畏催啦题感经厨峡庸剪源吧怨超裤踪贸滤艺同冰非遥司铜迈采妇瞎鼠干能弃叹英槐限狮灌弊栽强秩酿怒厌榴翠疮姓项袖余披溪缩找守凉警勾坟浓否热萌寺妈消阳抬恶柴去蚕较期从美代症舞培捏波聚应鞋弓格陪敢这佳浩蹈仁裹惨惑旬娃五江物小们逆租童沫寿辉弟寄盼习奸肥两叉姿喂击睬回班留鬼荐扶红寇瓶潜无后道次钥悬卷垂粥流会陡占嗽辽绵素莫颗巡揭灯控又像火仅窗延叛喊校趴横勿镰朽膜纵么图裙辈邻涂递戏殖排舌针蛙寸忌带营陵复载级赔返录掘骡鼻勤饮岁慨口绢询茧被吼下咱境冻家侮粮砖抽扁声聋梳哗杀看晌忧野伸劫虫插贵盏浆甘省微栏忘青任允农达逐心音独棉妄钱箭向笼输歌弄疗窝革篮站惜乌遇剑税尼井副偿威钓毛决听抵膏剥俊彻进摧扛室之烛阅怜胜辩萄怪放觉禽搂敏扎亩幕业镜姜天推胃探斗企想绣帅励按汽饲转洁资为杰多夫摊借跨酬刀犁环赵翻馆";
        int price=100;
        String picture="";
        String address="测试";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        int res=venueService.create(venue);
        assertTrue(res>0);
    }
    @Test
    void IT_TD_007_005_001_003(){
        int venueID=1;
        String venue_name="venue";
        String description="侍骄鱼炒鄙悠丙离程捧侦轧筑树乳似援滩短易踏案普偶蜘乘烫夕博把存世倒住喝裕暂胀黎玉率悦贩定湿蝇狱混鹿水板视娘叫郑稀剃馅驻唐熔担牺享来胸引袭息版惯堵豆刺妨梨师吉请纱耽惕阻沉虏拥崖庙俭其月念耗乒驼熊扣辜绝逼孟汉村清宽酷挨悲沈椅绕法腥蜜紧伤颂九东爪胆赞答缝塘田偏悼休狸迷参尾钻悄养观愤潮鸡含蔽液愁识御泰付句哄喜赤汗崭持饱悉仪耍浑棋萝块畏催啦题感经厨峡庸剪源吧怨超裤踪贸滤艺同冰非遥司铜迈采妇瞎鼠干能弃叹英槐限狮灌弊栽强秩酿怒厌榴翠疮姓项袖余披溪缩找守凉警勾坟浓否热萌寺妈消阳抬恶柴去蚕较期从美代症舞培捏波聚应鞋弓格陪敢这佳浩蹈仁裹惨惑旬娃五江物小们逆租童沫寿辉弟寄盼习奸肥两叉姿喂击睬回班留鬼荐扶红寇瓶潜无后道次钥悬卷垂粥流会陡占嗽辽绵素莫颗巡揭灯控又像火仅窗延叛喊校趴横勿镰朽膜纵么图裙辈邻涂递戏殖排舌针蛙寸忌带营陵复载级赔返录掘骡鼻勤饮岁慨口绢询茧被吼下咱境冻家侮粮砖抽扁声聋梳哗杀看晌忧野伸劫虫插贵盏浆甘省微栏忘青任允农达逐心音独棉妄钱箭向笼输歌弄疗窝革篮站惜乌遇剑税尼井副偿威钓毛决听抵膏剥俊彻进摧扛室之烛阅怜胜辩萄怪放觉禽搂敏扎亩幕业镜姜天推胃探斗企想绣帅励按汽饲转洁资为杰多夫摊借跨酬刀犁环赵翻馆";
        int price=100;
        String picture="";
        String address="奉胆猎炕购创囊斜抖壶齿参爪蠢温盒草识逗总部超棕舰互分答甚臭撒晌机沙用免丧砍字杯闭清隙痒说妻枣厦抱退至道葛治盯眨竖飘麦啄璃极爆无追冰鹊阔扔忆墨哭撇瑞持德爬量遵令轿椒挡牢择偿狼驳眠浸蓝石愉宵剥判咽痛亩绵赶秘纽蛾求纵争倒段邮捎攀新辈观保音炮听姓逐哑课钓命到剖喉";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        int res=venueService.create(venue);
        assertTrue(res>0);
    }
    @Test
    void IT_TD_007_005_001_004(){
        int venueID=1;
        String venue_name="venue";
        String description="侍骄鱼炒鄙悠丙离程捧侦轧筑树乳似援滩短易踏案普偶蜘乘烫夕博把存世倒住喝裕暂胀黎玉率悦贩定湿蝇狱混鹿水板视娘叫郑稀剃馅驻唐熔担牺享来胸引袭息版惯堵豆刺妨梨师吉请纱耽惕阻沉虏拥崖庙俭其月念耗乒驼熊扣辜绝逼孟汉村清宽酷挨悲沈椅绕法腥蜜紧伤颂九东爪胆赞答缝塘田偏悼休狸迷参尾钻悄养观愤潮鸡含蔽液愁识御泰付句哄喜赤汗崭持饱悉仪耍浑棋萝块畏催啦题感经厨峡庸剪源吧怨超裤踪贸滤艺同冰非遥司铜迈采妇瞎鼠干能弃叹英槐限狮灌弊栽强秩酿怒厌榴翠疮姓项袖余披溪缩找守凉警勾坟浓否热萌寺妈消阳抬恶柴去蚕较期从美代症舞培捏波聚应鞋弓格陪敢这佳浩蹈仁裹惨惑旬娃五江物小们逆租童沫寿辉弟寄盼习奸肥两叉姿喂击睬回班留鬼荐扶红寇瓶潜无后道次钥悬卷垂粥流会陡占嗽辽绵素莫颗巡揭灯控又像火仅窗延叛喊校趴横勿镰朽膜纵么图裙辈邻涂递戏殖排舌针蛙寸忌带营陵复载级赔返录掘骡鼻勤饮岁慨口绢询茧被吼下咱境冻家侮粮砖抽扁声聋梳哗杀看晌忧野伸劫虫插贵盏浆甘省微栏忘青任允农达逐心音独棉妄钱箭向笼输歌弄疗窝革篮站惜乌遇剑税尼井副偿威钓毛决听抵膏剥俊彻进摧扛室之烛阅怜胜辩萄怪放觉禽搂敏扎亩幕业镜姜天推胃探斗企想绣帅励按汽饲转洁资为杰多夫摊借跨酬刀犁环赵翻馆";
        int price=100;
        String picture="";
        String address="闭判这挨少俊折卡法宾逆纳绒绘烧脉愈链旺舟古捷捏四搁茄浪董脖哥反从悟扰降徒念朝疆靠循温份挂庆竿蜘杠雾插段姓买蔽邮稀至健伟谁神租劳购挺丑暑眠窃率分碰柴标包姿暗必康汉泥页撕蜓叠桶愁塘催准霞任妹桐饰皆宇短善养毕可鸡章祸报译哨膏劫际帖爽慎查乒故昌洋跨浩饭毅挥谅盈荣扁猪避前炭镇划裂贴箩归信州掩些各震放辜愧款俗起捧莲紧掉望辞测贡峰据此曲伐肢老亚多例虹难批滋操欺馒微囊播棕瓦沿颈矩孔弄消递欣雕匪挪义驼齐符闲刚隐残络堵透孕诸初所斤火辩吃剖拘尖赢僚井负亡朵饥绢伍珠笼巷渴练忠轧把盒剂株贯驰举配括效坟鸽肯锡借冶芒因昏变费";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        int res=venueService.create(venue);
        assertTrue(res>0);
    }
    @Test
    void IT_TD_007_005_001_005(){
        int venueID=1;
        String venue_name="venue";
        String description="侍骄鱼炒鄙悠丙离程捧侦轧筑树乳似援滩短易踏案普偶蜘乘烫夕博把存世倒住喝裕暂胀黎玉率悦贩定湿蝇狱混鹿水板视娘叫郑稀剃馅驻唐熔担牺享来胸引袭息版惯堵豆刺妨梨师吉请纱耽惕阻沉虏拥崖庙俭其月念耗乒驼熊扣辜绝逼孟汉村清宽酷挨悲沈椅绕法腥蜜紧伤颂九东爪胆赞答缝塘田偏悼休狸迷参尾钻悄养观愤潮鸡含蔽液愁识御泰付句哄喜赤汗崭持饱悉仪耍浑棋萝块畏催啦题感经厨峡庸剪源吧怨超裤踪贸滤艺同冰非遥司铜迈采妇瞎鼠干能弃叹英槐限狮灌弊栽强秩酿怒厌榴翠疮姓项袖余披溪缩找守凉警勾坟浓否热萌寺妈消阳抬恶柴去蚕较期从美代症舞培捏波聚应鞋弓格陪敢这佳浩蹈仁裹惨惑旬娃五江物小们逆租童沫寿辉弟寄盼习奸肥两叉姿喂击睬回班留鬼荐扶红寇瓶潜无后道次钥悬卷垂粥流会陡占嗽辽绵素莫颗巡揭灯控又像火仅窗延叛喊校趴横勿镰朽膜纵么图裙辈邻涂递戏殖排舌针蛙寸忌带营陵复载级赔返录掘骡鼻勤饮岁慨口绢询茧被吼下咱境冻家侮粮砖抽扁声聋梳哗杀看晌忧野伸劫虫插贵盏浆甘省微栏忘青任允农达逐心音独棉妄钱箭向笼输歌弄疗窝革篮站惜乌遇剑税尼井副偿威钓毛决听抵膏剥俊彻进摧扛室之烛阅怜胜辩萄怪放觉禽搂敏扎亩幕业镜姜天推胃探斗企想绣帅励按汽饲转洁资为杰多夫摊借跨酬刀犁环赵翻馆";
        int price=100;
        String picture="";
        String address="虫副鼠四印血幼攀恐湖仍秘粗鹿耍夜蜡忙旷咏属翠响转结侦黄贞虚谅锣由松屡钞空溉辽潮重进霜丸摩县纳洞迫烈困哥京暗保呼鲁崭吗铜卜夕持趴偏斯窄抖卵督矿障钢晃乱渐者习累吼董贫寿低凑停细项早稿愈浙北宣谣隐宏陕束巧嚷芝价陪宾无身料乖藏队乡粉虎雨侍休替拨肝供皇灯领归撤党朵雹令途棋惯购耐紫他靠方并嘱链山浑妇赖蝇听庙场纵件嗓醉唉晨牵灶洁相言逆躺疮曾库通筑止课洒爹扶另理久趋荒局喘土丰必爱疑袖哑舌木托铺资层丛本飘奏谊缺廊族寻林日司未掀围榜赏肚服给竖吞侄容捆蛛河础风棉旱淋裂盖胶桌毒遥截滚匪驻籍返逐角贡安轰获熄赤页臣瞒痒哪蓬妻终板伍朗";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        int res=venueService.create(venue);
        assertTrue(res>0);
    }
    @Test
    void IT_TD_007_005_001_006(){
        int venueID=1;
        String venue_name="venue";
        String description="侍骄鱼炒鄙悠丙离程捧侦轧筑树乳似援滩短易踏案普偶蜘乘烫夕博把存世倒住喝裕暂胀黎玉率悦贩定湿蝇狱混鹿水板视娘叫郑稀剃馅驻唐熔担牺享来胸引袭息版惯堵豆刺妨梨师吉请纱耽惕阻沉虏拥崖庙俭其月念耗乒驼熊扣辜绝逼孟汉村清宽酷挨悲沈椅绕法腥蜜紧伤颂九东爪胆赞答缝塘田偏悼休狸迷参尾钻悄养观愤潮鸡含蔽液愁识御泰付句哄喜赤汗崭持饱悉仪耍浑棋萝块畏催啦题感经厨峡庸剪源吧怨超裤踪贸滤艺同冰非遥司铜迈采妇瞎鼠干能弃叹英槐限狮灌弊栽强秩酿怒厌榴翠疮姓项袖余披溪缩找守凉警勾坟浓否热萌寺妈消阳抬恶柴去蚕较期从美代症舞培捏波聚应鞋弓格陪敢这佳浩蹈仁裹惨惑旬娃五江物小们逆租童沫寿辉弟寄盼习奸肥两叉姿喂击睬回班留鬼荐扶红寇瓶潜无后道次钥悬卷垂粥流会陡占嗽辽绵素莫颗巡揭灯控又像火仅窗延叛喊校趴横勿镰朽膜纵么图裙辈邻涂递戏殖排舌针蛙寸忌带营陵复载级赔返录掘骡鼻勤饮岁慨口绢询茧被吼下咱境冻家侮粮砖抽扁声聋梳哗杀看晌忧野伸劫虫插贵盏浆甘省微栏忘青任允农达逐心音独棉妄钱箭向笼输歌弄疗窝革篮站惜乌遇剑税尼井副偿威钓毛决听抵膏剥俊彻进摧扛室之烛阅怜胜辩萄怪放觉禽搂敏扎亩幕业镜姜天推胃探斗企想绣帅励按汽饲转洁资为杰多夫摊借跨酬刀犁环赵翻馆";
        int price=100;
        String picture="";
        String address="虫副鼠你四印血幼攀恐湖仍秘粗鹿耍夜蜡忙旷咏属翠响转结侦黄贞虚谅锣由松屡钞空溉辽潮重进霜丸摩县纳洞迫烈困哥京暗保呼鲁崭吗铜卜夕持趴偏斯窄抖卵督矿障钢晃乱渐者习累吼董贫寿低凑停细项早稿愈浙北宣谣隐宏陕束巧嚷芝价陪宾无身料乖藏队乡粉虎雨侍休替拨肝供皇灯领归撤党朵雹令途棋惯购耐紫他靠方并嘱链山浑妇赖蝇听庙场纵件嗓醉唉晨牵灶洁相言逆躺疮曾库通筑止课洒爹扶另理久趋荒局喘土丰必爱疑袖哑舌木托铺资层丛本飘奏谊缺廊族寻林日司未掀围榜赏肚服给竖吞侄容捆蛛河础风棉旱淋裂盖胶桌毒遥截滚匪驻籍返逐角贡安轰获熄赤页臣瞒痒哪蓬妻终板伍朗";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        assertThrows(RuntimeException.class,
                ()->venueService.create(venue));
    }
    @Test
    void IT_TD_007_005_001_007(){
        int venueID=1;
        String venue_name="venue";
        String description="";
        int price=100;
        String picture="";
        String address="奉胆猎炕购创囊斜抖壶齿参爪蠢温盒草识逗总部超棕舰互分答甚臭撒晌机沙用免丧砍字杯闭清隙痒说妻枣厦抱退至道葛治盯眨竖飘麦啄璃极爆无追冰鹊阔扔忆墨哭撇瑞持德爬量遵令轿椒挡牢择偿狼驳眠浸蓝石愉宵剥判咽痛亩绵赶秘纽蛾求纵争倒段邮捎攀新辈观保音炮听姓逐哑课钓命到剖喉";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        int res=venueService.create(venue);
        assertTrue(res>0);
    }
    @Test
    void IT_TD_007_005_001_008(){
        int venueID=1;
        String venue_name="venue";
        String description="测试";
        int price=100;
        String picture="";
        String address="奉胆猎炕购创囊斜抖壶齿参爪蠢温盒草识逗总部超棕舰互分答甚臭撒晌机沙用免丧砍字杯闭清隙痒说妻枣厦抱退至道葛治盯眨竖飘麦啄璃极爆无追冰鹊阔扔忆墨哭撇瑞持德爬量遵令轿椒挡牢择偿狼驳眠浸蓝石愉宵剥判咽痛亩绵赶秘纽蛾求纵争倒段邮捎攀新辈观保音炮听姓逐哑课钓命到剖喉";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        int res=venueService.create(venue);
        assertTrue(res>0);
    }
    @Test
    void IT_TD_007_005_001_009(){
        int venueID=1;
        String venue_name="venue";
        String description="陡督择泊瞧乞肠挎陪识担要赠桂滚夫画获扶阻次满扛撕车机替森虑闲断搜珠膏蒸造像抢犯普涉餐彩柜戒涨肤奏诊平议你牲摸性霞片冷惨花溪毙乌欧猛产捞虎嚼熊赴穿执葡绑卸驼窜颗齿董积府帮浸拒尾舍腹堆占锐绒琴宵貌谱炭怠疗捕扒征宏悟狐们触做附拆盐付室三最紫易煌妈金侄纸胖伴伟丢女蚂令活晚改采羽法洽挑赢货已插凝微艺呢余掀桌埋德梨态买梢通喜燕吴跃换文己资鞠枕百裙杯归脉越订撇疼气兴苦鲁姜载昆六理群敏进落类涛喷傲冰桃扁商足娇装岭注耻有尽孝程怕耳敞深拼霜厚批浆沙那抹寿挽茶滨只须凭芳显罩睡然京差放冠创牛巡斧膊舟挥苏丑项辽计笛躺罚宴培档娘季丧奇阅海线抖公萄肉蜜绘腾份孤问坚实奶稼贪连势贷限雅朗度夜呀蕉顶疤逃蛛觉戴候举迁屠英矮筝宽赞午爷山明快绢馅哲钩光勤禽白逐怀罪截殃奋棵失液艘赤蚀烦邀遍欲鹰荒脱宜夕知括术锦遵值十蝶恨碑慌肃孩减查斯跪犹南稻拴评乃符警峰酬单止着荷尼角口入缴劫误避萝卷弱选贸桨奥茅轰飘鹊汽鹅各水肯陷沉驶柄韵渐虾团龙居且砍野或狡妖笑超渗豆烈伸胜疲副及促杂恢齐亏猾诉留蜂斑功随宣墙闹规症袖重以渡绪乐刃战展窝痕牢播欠凉扇瓣沸闸洒官翻钻桐畜献他蹄垒躁劈熟壁仓谷介薪币谋联戚禾咐竟幅每崖呜镰黄辆捉樱晶厨伶遭授低取棋握测饲吨弃浓勉干撞电返职挖亮骆挣潜绕嗓街掠宇窄虚扣灶婚壶炕滤郊拦寻弊焰湾饶鸭壳受旺僻钉杏影慰炸凶旅伏伐末钳巷净笋束浊床蹦锯忧级傻弓堡怨迷星扯吐辛作镇昂际胀没友队芹假赖抚咸练丽号道日沃径阳痰努姐党仙看炮舒期蜡蝴纱院上样间推踩纳惜掏梅扮泄遗至除四耀圆修参羊芝刚碗袋舅在港论届慕猪叙总完累钟果软老再贱叠国鬼士尝井杨侦捡组婶瑞卖刑贴删岸写朝纹速善汪椒伞目俊忌谜肝幕边顺弄巧紧渠呼阵眨许核捎陕决刊所离植秀誉吉靠厕突毫怖另福祝激刀肢哀胸翁两型鸽面容财榴子灾涌垮涝欣情牺列拉该排疫形词书否考圾蓝万存什泡帐而锣曾外发缠贫闯吞请宫伪想价岩西茧慈牙高串偿异支人摇艇划叨谦启塑赌物瘦尚兆悼元吹殿耗泽颠恶辜搏昼守缘母揭境辈很逢收跟板备骡运灌探胡戏乱凑嫩疯锄逝赏忘榆挂宝趋首筹朴霉摩初苗简世爱填烛帅界蛙畅愧印咏陆签基娱观牌灰昌辩敬结悉少惧儿洪毕算贿钢卫袜竖难盖会盛恩萍兼无似穷始提躲融雄稍继张劲舰帝嫂熄予惊彻怜哨魂色表蔑年茄莫抵颂帽短由阶必湿检婆俭柴象园秆洗朱桑州土仿动背循浙数赔交依量蜓锋股铅若辨升扫送折磨月制犁弹案质却仔隆横箱优滥趁复梯报抽抬昨趣矿奖家遮匙厉雁息球脚喝洲撑虽名健屈屯馒律厌伤葬闪伍励搭饼申鸦松仆悄嘴芬寺";
        int price=100;
        String picture="";
        String address="奉胆猎炕购创囊斜抖壶齿参爪蠢温盒草识逗总部超棕舰互分答甚臭撒晌机沙用免丧砍字杯闭清隙痒说妻枣厦抱退至道葛治盯眨竖飘麦啄璃极爆无追冰鹊阔扔忆墨哭撇瑞持德爬量遵令轿椒挡牢择偿狼驳眠浸蓝石愉宵剥判咽痛亩绵赶秘纽蛾求纵争倒段邮捎攀新辈观保音炮听姓逐哑课钓命到剖喉";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        int res=venueService.create(venue);
        assertTrue(res>0);
    }
    @Test
    void IT_TD_007_005_001_010(){
        int venueID=1;
        String venue_name="venue";
        String description="测试测试测试测试测试陡督择泊瞧乞肠挎陪识担要赠桂滚夫画获扶阻次满扛撕车机替森虑闲断搜珠膏蒸造像抢犯普涉餐彩柜戒涨肤奏诊平议你牲摸性霞片冷惨花溪毙乌欧猛产捞虎嚼熊赴穿执葡绑卸驼窜颗齿董积府帮浸拒尾舍腹堆占锐绒琴宵貌谱炭怠疗捕扒征宏悟狐们触做附拆盐付室三最紫易煌妈金侄纸胖伴伟丢女蚂令活晚改采羽法洽挑赢货已插凝微艺呢余掀桌埋德梨态买梢通喜燕吴跃换文己资鞠枕百裙杯归脉越订撇疼气兴苦鲁姜载昆六理群敏进落类涛喷傲冰桃扁商足娇装岭注耻有尽孝程怕耳敞深拼霜厚批浆沙那抹寿挽茶滨只须凭芳显罩睡然京差放冠创牛巡斧膊舟挥苏丑项辽计笛躺罚宴培档娘季丧奇阅海线抖公萄肉蜜绘腾份孤问坚实奶稼贪连势贷限雅朗度夜呀蕉顶疤逃蛛觉戴候举迁屠英矮筝宽赞午爷山明快绢馅哲钩光勤禽白逐怀罪截殃奋棵失液艘赤蚀烦邀遍欲鹰荒脱宜夕知括术锦遵值十蝶恨碑慌肃孩减查斯跪犹南稻拴评乃符警峰酬单止着荷尼角口入缴劫误避萝卷弱选贸桨奥茅轰飘鹊汽鹅各水肯陷沉驶柄韵渐虾团龙居且砍野或狡妖笑超渗豆烈伸胜疲副及促杂恢齐亏猾诉留蜂斑功随宣墙闹规症袖重以渡绪乐刃战展窝痕牢播欠凉扇瓣沸闸洒官翻钻桐畜献他蹄垒躁劈熟壁仓谷介薪币谋联戚禾咐竟幅每崖呜镰黄辆捉樱晶厨伶遭授低取棋握测饲吨弃浓勉干撞电返职挖亮骆挣潜绕嗓街掠宇窄虚扣灶婚壶炕滤郊拦寻弊焰湾饶鸭壳受旺僻钉杏影慰炸凶旅伏伐末钳巷净笋束浊床蹦锯忧级傻弓堡怨迷星扯吐辛作镇昂际胀没友队芹假赖抚咸练丽号道日沃径阳痰努姐党仙看炮舒期蜡蝴纱院上样间推踩纳惜掏梅扮泄遗至除四耀圆修参羊芝刚碗袋舅在港论届慕猪叙总完累钟果软老再贱叠国鬼士尝井杨侦捡组婶瑞卖刑贴删岸写朝纹速善汪椒伞目俊忌谜肝幕边顺弄巧紧渠呼阵眨许核捎陕决刊所离植秀誉吉靠厕突毫怖另福祝激刀肢哀胸翁两型鸽面容财榴子灾涌垮涝欣情牺列拉该排疫形词书否考圾蓝万存什泡帐而锣曾外发缠贫闯吞请宫伪想价岩西茧慈牙高串偿异支人摇艇划叨谦启塑赌物瘦尚兆悼元吹殿耗泽颠恶辜搏昼守缘母揭境辈很逢收跟板备骡运灌探胡戏乱凑嫩疯锄逝赏忘榆挂宝趋首筹朴霉摩初苗简世爱填烛帅界蛙畅愧印咏陆签基娱观牌灰昌辩敬结悉少惧儿洪毕算贿钢卫袜竖难盖会盛恩萍兼无似穷始提躲融雄稍继张劲舰帝嫂熄予惊彻怜哨魂色表蔑年茄莫抵颂帽短由阶必湿检婆俭柴象园秆洗朱桑州土仿动背循浙数赔交依量蜓锋股铅若辨升扫送折磨月制犁弹案质却仔隆横箱优滥趁复梯报抽抬昨趣矿奖家遮匙厉雁息球脚喝洲撑虽名健屈屯馒律厌伤葬闪伍励搭饼申鸦松仆悄嘴芬寺";
        int price=100;
        String picture="";
        String address="奉胆猎炕购创囊斜抖壶齿参爪蠢温盒草识逗总部超棕舰互分答甚臭撒晌机沙用免丧砍字杯闭清隙痒说妻枣厦抱退至道葛治盯眨竖飘麦啄璃极爆无追冰鹊阔扔忆墨哭撇瑞持德爬量遵令轿椒挡牢择偿狼驳眠浸蓝石愉宵剥判咽痛亩绵赶秘纽蛾求纵争倒段邮捎攀新辈观保音炮听姓逐哑课钓命到剖喉";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        int res=venueService.create(venue);
        assertTrue(res>0);
    }
    @Test
    void IT_TD_007_005_001_011(){
        int venueID=1;
        String venue_name="venue";
        String description="测测试测试测试测试测试陡督择泊瞧乞肠挎陪识担要赠桂滚夫画获扶阻次满扛撕车机替森虑闲断搜珠膏蒸造像抢犯普涉餐彩柜戒涨肤奏诊平议你牲摸性霞片冷惨花溪毙乌欧猛产捞虎嚼熊赴穿执葡绑卸驼窜颗齿董积府帮浸拒尾舍腹堆占锐绒琴宵貌谱炭怠疗捕扒征宏悟狐们触做附拆盐付室三最紫易煌妈金侄纸胖伴伟丢女蚂令活晚改采羽法洽挑赢货已插凝微艺呢余掀桌埋德梨态买梢通喜燕吴跃换文己资鞠枕百裙杯归脉越订撇疼气兴苦鲁姜载昆六理群敏进落类涛喷傲冰桃扁商足娇装岭注耻有尽孝程怕耳敞深拼霜厚批浆沙那抹寿挽茶滨只须凭芳显罩睡然京差放冠创牛巡斧膊舟挥苏丑项辽计笛躺罚宴培档娘季丧奇阅海线抖公萄肉蜜绘腾份孤问坚实奶稼贪连势贷限雅朗度夜呀蕉顶疤逃蛛觉戴候举迁屠英矮筝宽赞午爷山明快绢馅哲钩光勤禽白逐怀罪截殃奋棵失液艘赤蚀烦邀遍欲鹰荒脱宜夕知括术锦遵值十蝶恨碑慌肃孩减查斯跪犹南稻拴评乃符警峰酬单止着荷尼角口入缴劫误避萝卷弱选贸桨奥茅轰飘鹊汽鹅各水肯陷沉驶柄韵渐虾团龙居且砍野或狡妖笑超渗豆烈伸胜疲副及促杂恢齐亏猾诉留蜂斑功随宣墙闹规症袖重以渡绪乐刃战展窝痕牢播欠凉扇瓣沸闸洒官翻钻桐畜献他蹄垒躁劈熟壁仓谷介薪币谋联戚禾咐竟幅每崖呜镰黄辆捉樱晶厨伶遭授低取棋握测饲吨弃浓勉干撞电返职挖亮骆挣潜绕嗓街掠宇窄虚扣灶婚壶炕滤郊拦寻弊焰湾饶鸭壳受旺僻钉杏影慰炸凶旅伏伐末钳巷净笋束浊床蹦锯忧级傻弓堡怨迷星扯吐辛作镇昂际胀没友队芹假赖抚咸练丽号道日沃径阳痰努姐党仙看炮舒期蜡蝴纱院上样间推踩纳惜掏梅扮泄遗至除四耀圆修参羊芝刚碗袋舅在港论届慕猪叙总完累钟果软老再贱叠国鬼士尝井杨侦捡组婶瑞卖刑贴删岸写朝纹速善汪椒伞目俊忌谜肝幕边顺弄巧紧渠呼阵眨许核捎陕决刊所离植秀誉吉靠厕突毫怖另福祝激刀肢哀胸翁两型鸽面容财榴子灾涌垮涝欣情牺列拉该排疫形词书否考圾蓝万存什泡帐而锣曾外发缠贫闯吞请宫伪想价岩西茧慈牙高串偿异支人摇艇划叨谦启塑赌物瘦尚兆悼元吹殿耗泽颠恶辜搏昼守缘母揭境辈很逢收跟板备骡运灌探胡戏乱凑嫩疯锄逝赏忘榆挂宝趋首筹朴霉摩初苗简世爱填烛帅界蛙畅愧印咏陆签基娱观牌灰昌辩敬结悉少惧儿洪毕算贿钢卫袜竖难盖会盛恩萍兼无似穷始提躲融雄稍继张劲舰帝嫂熄予惊彻怜哨魂色表蔑年茄莫抵颂帽短由阶必湿检婆俭柴象园秆洗朱桑州土仿动背循浙数赔交依量蜓锋股铅若辨升扫送折磨月制犁弹案质却仔隆横箱优滥趁复梯报抽抬昨趣矿奖家遮匙厉雁息球脚喝洲撑虽名健屈屯馒律厌伤葬闪伍励搭饼申鸦松仆悄嘴芬寺";
        int price=100;
        String picture="";
        String address="奉胆猎炕购创囊斜抖壶齿参爪蠢温盒草识逗总部超棕舰互分答甚臭撒晌机沙用免丧砍字杯闭清隙痒说妻枣厦抱退至道葛治盯眨竖飘麦啄璃极爆无追冰鹊阔扔忆墨哭撇瑞持德爬量遵令轿椒挡牢择偿狼驳眠浸蓝石愉宵剥判咽痛亩绵赶秘纽蛾求纵争倒段邮捎攀新辈观保音炮听姓逐哑课钓命到剖喉";
        String open_time="08:00";
        String close_time="18:00";
        Venue venue=new Venue(venueID,venue_name,description,price,picture,address,open_time,close_time);
        assertThrows(RuntimeException.class,
                ()->venueService.create(venue));
    }
    @Test
    void IT_TD_007_008_001_001(){
        int res1=venueService.countVenueName("同济大学嘉定校区图书馆14楼1405室");
        assertEquals(1,res1);

    }
    @Test
    void IT_TD_007_008_002_001(){
        int res2=venueService.countVenueName("测试");
        assertEquals(0,res2);
    }
    @Test
    public void IT_TD_007_007_001_001(){
        venueService.delById(29);
    }

    @Test
    public void IT_TD_007_007_002_001(){
        assertThrows(EmptyResultDataAccessException .class,
                ()-> venueService.delById(250));
    }
}
