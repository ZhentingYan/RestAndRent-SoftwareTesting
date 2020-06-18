package com.meethere.IntegrationTest.Controller.Admin;

import com.meethere.MeetHereApplication;
import com.meethere.entity.Venue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MeetHereApplication.class)
@AutoConfigureMockMvc
@Transactional
public class AdminVenueApiTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void IT_TD_009_005_001_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","丢船泥若绸山邻当诸找纵窃南相屿宵继泪筐委奋拒斥规锹庙朝绍雪剑音紫熄航饱体讽慌然杰暖构蔑养狱由宽味扛汤刘脂支嫩业删比战够胶腔剂商棉粗寄弱豪守写和荷押膜寸吃热敞允魄闻集丧暮逗初欺葛爽济愤饼胳公凉求光塔状谣炭杆傲精帖讨彻照耍月苍态屡扣昏洽牺说碑鸡承服项柄了竿殃馋巷分抓烧霜队升肠老梨窝牵倾恢奥医第酿骂砍囊协屯抚死招糖挎入况熔冈御熟盖堤不傻今币宏前识立孤斗蛾炉须危栗喝扁详慨滤斤垫历蓬佩朽献匀没谁绣合怠舱孟河道刀昆端渗狡鹅健较劳宇弯萍其愁府审布烈轮牙田寨坏数只鸟兵推哈射镰温哥僵厌尊纷皮静敬脏锻逆涉酷一末坡杂恩津实责许")
                        .param("description","陪龙留遗烂娘固装杂侄袍萍唐继凳封日路招驶晓寻捆盘译冲远是纷僵宰屿因垄芦示轰盒硬朵涛软使幼涝狭孟折仍烛粮荡坊范深倾阵糖谁姥侮丈冠纹公秩灶荣钓驰镰铃窝邮络控织胆借睁旨残雷闷辩惩发病翁炸舌泡审股成暮响街诞圆茫语不末检库近滋揪贺并预架械饼渠民暂记偶伴敢求辨时毒息忽宾砌试状六池丽巷携驳双士哲罚客类蔑棍故博酬马列焰凤敏简跪辛巧必鸣女回悼做减仿爬传锁驱凝梨喇猜吹梦兄弄屋宙缩法按剑唇钉恢值秤雹售肚忌筐辱衫看躬绣奇告派园塌顾熔绑丙露迟苦疮干迎木似羊验斜沃览笔扶权愈旗中温绪样些惹越忙泰乱李血应旦件蓄项判了底枝钩吵份坚杰备秧遣概层郊踏烟虫舞集袭沟弯仔鄙四待半霜丝要奖脚丢弊烧启逃否智再业筒泥劳骗毕微前肆妨薯寸造闸盟早写袋虹二象背哑国喉污榨邪湖茎搜患雪职尖芹纽瘦娱蔽岛罗笛刊耗摧码撇毛创详惜删袄显适标姑杨剂数趴卫召纸傍躁书迁拳佣闹婚危黎组透好歇横着抢腹陵尾票泪费气巨厕扒美尚肉称嘉滔城却踪扬翻震懒皱肃罢廉惭拥秃甘含行那她务鹅捡索撞字盆咱冻鼠放森望蒸胶液孝室隆醒海代浸振突摸逮体存陕蜘群午课猛幸云宁主塞孩妥恼仅呼档墙程东勉炕疼闲零擦德喂设鲜某繁践奉伏蓬既净秘界占细熄睡壤毅火萄实拾旬肺破潜穷蝶馆营呀滨捉窜壶伤察溉防财衰今快徒壳辟脉贯丸奥颠谅万壮栋姿动耳资昼献刀驻伸莫鉴坏添胞共酸慎农帝地爱君忆瞒维踢游般录另威约厘洗篮岭嫁崖泛惨功散侦洲台焦枪蒜揭捎抽寇洋益挨右盈赤港潮寄锡况贱俱竹沾严吞眼屠各堤冷衣粥把失河轧捞岩阀三鸦挠锹误布艰梯米丁峰欧桃者受丘祝光昆猾瓣全碗斤魔志弱呢挂释浑劲径樱稼纳糠胜孙闻极播顽粉家总虑悉逐娃倚卜亚虏店子培惊金愉剖谊佳斧凶难晚灌浓乔顺蚕黄驾宋班现俯紧独坝收击惑逢蝴注疤途沉愤杏西圾笼绒筋退八文庭或喊猪晶仁艇曾皆允测史朴迹罩叔承基尝嘴抓嗽轻逼众骤学厉辞医恭端属菌讨驼赛纲岂炮甩霸砖渡刮洪太牛划旁倒首哨星巩每型酒脏败汪十力捧挖乖私夕津争兆彻隐餐句膊柄依枯础幕膨束院贸凯至陡让葵叨泻葬宿赶燕如矛颜射裳伐次盗畅丹顷匠妙霉禾取接健仙摇论瓜拼科感什歌居银哈帽念殖困变杠边肠猫宫衬埋秆球强去俗疯刃巡林挽精建华袖获归乓宇懂狠赢晕梢爪禁炎痒症桥跳捷醉鸭块空州赞唉亮抖期耀扁跌秒遇汇耕乃假蜻鬼声腥催切处湿虾鞭荷珠剪掉搅愁蚂括校盾觉洽傅香对泽杆绸昏忠旺车司甚薄搏候川绞童略棋怒椒尺姨狱碑拦青欣清搁立搞征皂禽儿落玉堡呈京壁官帐解悬副御除询紫县饭违迈桑痛何盯段勇浮萝亿乘员舅你选饲周眠供蜡螺身销两蛋负著脑晋锻溪裤棵绢妈炼慕橡恋").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
    }
    @Test
    public void IT_TD_009_005_002_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","断冲刑现四自货虽嫩辛翠控境杨肾鼠最伶烂滤客筐战枪候擦逆处果更叙显壤岸城暂锋疲男化兽份乎僚珍酸统姜棉携返器哲采叮欣追陶吼向瞧议写医牵滚始胖航致券拆阅多蒸炼缴庄毅鞋基要脖将量之潜奸险充汽肩休郑冒罢柴鱼腊耀周梨部备早通萌楼绕牲丙曲旱吉具厉金膝晌乳审按辉顿海乱封掌板孝长符丛晨守例爪孩经钩泡蜓艺蓄膏拍鸟狂帜马厂庆诵卖铺鹊后涨删西荐失纺逐馆妄欧乏劳污怠史柏妹完床柜孕嘱族墓但用殿镜掩今斧匹偶述朴外味站互据抬若略县历羞王暖毯做旅俩在毕健脾麻岁庭乐茂杜烦抛吧垫整吗顷循蛙润厦场怖宅途本辞别喉答详宪狮颗渣证戚恢峡妙新督宿为干狸")
                        .param("description","迅团寺任辣钳当仙乎面惑变让搏挺伟背忍糠虹洪愿监特录践瓦燥往佣已力饱迎厦酸违嫩明意吉谎困洒桨泛羡尊实泥示律称费完私贡晨答喇鄙浸进奋座管蠢拴炮粪肆风衣妙岩辞揉额由惧斜弟跨境屋染仓都稳勇愚闹围学指煌抹处救莫失丸龙繁匠叨垂签热易舒件释筋搬援翠地帅掩帝古重抢待授否爹千孤铸库此篇中槐滥象宫警陷皂循联为咏清袖双秤麦帐久阶迟养兰盟盯罢诞好纯伸披级优技旨映秧透粮威厉垮航鞠盏九蚕非逗凳徒眠灯血捉彼贸源叹叫丝幻值返蚊萌唤京跃俭看邻声句秘臣润超极殿欺蜂炎汪屑轰洽冤铺蜘章牛拘颠抬谅乒嘉糊鸡拌滤岭标疗式产赤窄喘咸扮雕略炼果书辟臂邀戴狮赢匪丛粱公鞋扩导姓牧樱协烈怨逃印村吨府委持筑乔盗物脾绪犹舟半仗受脆检然民玻卷念笔铲坡昌劣偏培殊挠居梅谜赚万丘嫌纹庙悄案劳间艰粗做胳垄问房作缎票珠战跟毙鹊突祸后碧蛙享吼呀承糖骂斯治睬葵线路挡席钞泰细积腾时刺旗薪刮廊松柳绘扔夕胶侨盈升悼金暑剑塌黎串月我残讨灶陵译厨恐跳气钻紫宴予苗毕只卡绿教罩军太暴改附兴开欢规浆阀趁许刃旷罐逼笼云午色数渴锁争累鸽谣毯平草丹调直登摆画棚番扣交没以萍品骑傲购呈工斑箭鼠针朗慨角秆塘据雾慧阁微计仆道箱减旱疆北粥津赖者馋氏祖淹拆益来险岗肝胞弱乏越狡审湾溜菊代胸饺遵顶塔攻狗吵迷桐睡说款灰凯短叉株欧六坐贴鼓演华锻逮炒豆包从反狸亮胆弃赌芦汉总室亡良差萝自锣赵锐弓雀把赏铁终亦壤野生宣贤挽馅还迹户抚接浙膏四砍帆星扇挥普辜首派术脸将荣帽瞎乙枯锦音取尽屿事扭盐茶鲜惨秒雁伍远雅狐猎庭痰颗咬厕扰岸令随补蚁孝寸喷啄恨秀撇贞厌满督窃插艇堵驳睁底澡衰去押虎花呼住酷艺沟厘之衬俘歪犁烧愤项讯杨凑沈槽众毛虏祥吐而仅论葱裹邮猛避啦堪目悬回旋守探艘杰垦率哥博殖右拦甘扎下政富辈荡絮病雪挂辩美准等就衫菜漫吸期珍绞袍温机惕霞借榴侵恳络尚剥顾孩丧得诊社腔耻拉萄旁聚搭租溉留嗓软稼要闪脖蒙己闯潮遍拥尝缩笨骄独屈茫拳汇抽辰拣竟乳轮纠站颂镜炭送泽鞭肚结劈试贪疤兆捧唇冬梯妈础捷灌册切腿充光摧院俗李认或消纤宵姐唱壮芹诗锋辛挣度局纱郊缝井浅堂僚显闸致复责纸叙奖凡钥挎谁勾摇料评个窜压梨饮眼关转舰手煮兔材绑么徐用怎乓练寒业球枝帖容归惰启姨师趣促袜斤买默滩旬估放跑贺唯裤蓬叛宜畅研信全街汤诸韵哪伤响衔塑家鲁筛杂喜界帘娱扬耍换零米哑熟洋艳椅辫身河匹燕伐俩体橘狼善架渗虫镰昼竿麻鱼精川晓桂但肠狭赞肺洲穗谷扫林禾山种瓶甩桌芽触驻哄秩省范牺树波丙灭功拔八访霜命筐汽侮筝渡芒蝴慈帜寄桑裙役白南枕娇慎族狂般著滋孔抛痛正猴稿绳桥").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"字段长度过长，请重新修改！");
    }

    @Test
    public void IT_TD_009_005_002_002() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","断冲刑现四自货虽嫩辛翠控境杨肾鼠最伶烂滤客筐战枪候擦逆处果更叙显壤岸城暂锋疲男化兽份乎僚珍酸统姜棉携返器哲采叮欣追陶吼向瞧议写医牵滚始胖航致券拆阅多蒸炼缴庄毅鞋基要脖将量之潜奸险充汽肩休郑冒罢柴鱼腊耀周梨部备早通萌楼绕牲丙曲旱吉具厉金膝晌乳审按辉顿海乱封掌板孝长符丛晨守例爪孩经钩泡蜓艺蓄膏拍鸟狂帜马厂庆诵卖铺鹊后涨删西荐失纺逐馆妄欧乏劳污怠史柏妹完床柜孕嘱族墓但用殿镜掩今斧匹偶述朴外味站互据抬若略县历羞王暖毯做旅俩在毕健脾麻岁庭乐茂杜烦抛吧垫整吗顷循蛙润厦场怖宅途本辞别喉答详宪狮颗渣证戚恢峡妙新督宿为干狸茅")
                        .param("description","迅团寺任辣钳当仙乎面惑变让搏挺伟背忍糠虹洪愿监特录践瓦燥往佣已力饱迎厦酸违嫩明意吉谎困洒桨泛羡尊实泥示律称费完私贡晨答喇鄙浸进奋座管蠢拴炮粪肆风衣妙岩辞揉额由惧斜弟跨境屋染仓都稳勇愚闹围学指煌抹处救莫失丸龙繁匠叨垂签热易舒件释筋搬援翠地帅掩帝古重抢待授否爹千孤铸库此篇中槐滥象宫警陷皂循联为咏清袖双秤麦帐久阶迟养兰盟盯罢诞好纯伸披级优技旨映秧透粮威厉垮航鞠盏九蚕非逗凳徒眠灯血捉彼贸源叹叫丝幻值返蚊萌唤京跃俭看邻声句秘臣润超极殿欺蜂炎汪屑轰洽冤铺蜘章牛拘颠抬谅乒嘉糊鸡拌滤岭标疗式产赤窄喘咸扮雕略炼果书辟臂邀戴狮赢匪丛粱公鞋扩导姓牧樱协烈怨逃印村吨府委持筑乔盗物脾绪犹舟半仗受脆检然民玻卷念笔铲坡昌劣偏培殊挠居梅谜赚万丘嫌纹庙悄案劳间艰粗做胳垄问房作缎票珠战跟毙鹊突祸后碧蛙享吼呀承糖骂斯治睬葵线路挡席钞泰细积腾时刺旗薪刮廊松柳绘扔夕胶侨盈升悼金暑剑塌黎串月我残讨灶陵译厨恐跳气钻紫宴予苗毕只卡绿教罩军太暴改附兴开欢规浆阀趁许刃旷罐逼笼云午色数渴锁争累鸽谣毯平草丹调直登摆画棚番扣交没以萍品骑傲购呈工斑箭鼠针朗慨角秆塘据雾慧阁微计仆道箱减旱疆北粥津赖者馋氏祖淹拆益来险岗肝胞弱乏越狡审湾溜菊代胸饺遵顶塔攻狗吵迷桐睡说款灰凯短叉株欧六坐贴鼓演华锻逮炒豆包从反狸亮胆弃赌芦汉总室亡良差萝自锣赵锐弓雀把赏铁终亦壤野生宣贤挽馅还迹户抚接浙膏四砍帆星扇挥普辜首派术脸将荣帽瞎乙枯锦音取尽屿事扭盐茶鲜惨秒雁伍远雅狐猎庭痰颗咬厕扰岸令随补蚁孝寸喷啄恨秀撇贞厌满督窃插艇堵驳睁底澡衰去押虎花呼住酷艺沟厘之衬俘歪犁烧愤项讯杨凑沈槽众毛虏祥吐而仅论葱裹邮猛避啦堪目悬回旋守探艘杰垦率哥博殖右拦甘扎下政富辈荡絮病雪挂辩美准等就衫菜漫吸期珍绞袍温机惕霞借榴侵恳络尚剥顾孩丧得诊社腔耻拉萄旁聚搭租溉留嗓软稼要闪脖蒙己闯潮遍拥尝缩笨骄独屈茫拳汇抽辰拣竟乳轮纠站颂镜炭送泽鞭肚结劈试贪疤兆捧唇冬梯妈础捷灌册切腿充光摧院俗李认或消纤宵姐唱壮芹诗锋辛挣度局纱郊缝井浅堂僚显闸致复责纸叙奖凡钥挎谁勾摇料评个窜压梨饮眼关转舰手煮兔材绑么徐用怎乓练寒业球枝帖容归惰启姨师趣促袜斤买默滩旬估放跑贺唯裤蓬叛宜畅研信全街汤诸韵哪伤响衔塑家鲁筛杂喜界帘娱扬耍换零米哑熟洋艳椅辫身河匹燕伐俩体橘狼善架渗虫镰昼竿麻鱼精川晓桂但肠狭赞肺洲穗谷扫林禾山种瓶甩桌芽触驻哄秩省范牺树波丙灭功拔八访霜命筐汽侮筝渡芒蝴慈帜寄桑裙役白南枕娇慎族狂般著滋孔抛痛正猴稿绳").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        //ResultActions perform=mockMvc.perform(builder);
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"字段长度过长，请重新修改！");
    }
    @Test
    public void IT_TD_009_005_003_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","丢船泥若绸山邻当诸找纵窃南相屿宵继泪筐委奋拒斥规锹庙朝绍雪剑音紫熄航饱体讽慌然杰暖构蔑养狱由宽味扛汤刘脂支嫩业删比战够胶腔剂商棉粗寄弱豪守写和荷押膜寸吃热敞允魄闻集丧暮逗初欺葛爽济愤饼胳公凉求光塔状谣炭杆傲精帖讨彻照耍月苍态屡扣昏洽牺说碑鸡承服项柄了竿殃馋巷分抓烧霜队升肠老梨窝牵倾恢奥医第酿骂砍囊协屯抚死招糖挎入况熔冈御熟盖堤不傻今币宏前识立孤斗蛾炉须危栗喝扁详慨滤斤垫历蓬佩朽献匀没谁绣合怠舱孟河道刀昆端渗狡鹅健较劳宇弯萍其愁府审布烈轮牙田寨坏数只鸟兵推哈射镰温哥僵厌尊纷皮静敬脏锻逆涉酷一末坡杂恩津实责许")
                        .param("description","陪龙留遗烂娘固装杂侄袍萍唐继凳封日路招驶晓寻捆盘译冲远是纷僵宰屿因垄芦示轰盒硬朵涛软使幼涝狭孟折仍烛粮荡坊范深倾阵糖谁姥侮丈冠纹公秩灶荣钓驰镰铃窝邮络控织胆借睁旨残雷闷辩惩发病翁炸舌泡审股成暮响街诞圆茫语不末检库近滋揪贺并预架械饼渠民暂记偶伴敢求辨时毒息忽宾砌试状六池丽巷携驳双士哲罚客类蔑棍故博酬马列焰凤敏简跪辛巧必鸣女回悼做减仿爬传锁驱凝梨喇猜吹梦兄弄屋宙缩法按剑唇钉恢值秤雹售肚忌筐辱衫看躬绣奇告派园塌顾熔绑丙露迟苦疮干迎木似羊验斜沃览笔扶权愈旗中温绪样些惹越忙泰乱李血应旦件蓄项判了底枝钩吵份坚杰备秧遣概层郊踏烟虫舞集袭沟弯仔鄙四待半霜丝要奖脚丢弊烧启逃否智再业筒泥劳骗毕微前肆妨薯寸造闸盟早写袋虹二象背哑国喉污榨邪湖茎搜患雪职尖芹纽瘦娱蔽岛罗笛刊耗摧码撇毛创详惜删袄显适标姑杨剂数趴卫召纸傍躁书迁拳佣闹婚危黎组透好歇横着抢腹陵尾票泪费气巨厕扒美尚肉称嘉滔城却踪扬翻震懒皱肃罢廉惭拥秃甘含行那她务鹅捡索撞字盆咱冻鼠放森望蒸胶液孝室隆醒海代浸振突摸逮体存陕蜘群午课猛幸云宁主塞孩妥恼仅呼档墙程东勉炕疼闲零擦德喂设鲜某繁践奉伏蓬既净秘界占细熄睡壤毅火萄实拾旬肺破潜穷蝶馆营呀滨捉窜壶伤察溉防财衰今快徒壳辟脉贯丸奥颠谅万壮栋姿动耳资昼献刀驻伸莫鉴坏添胞共酸慎农帝地爱君忆瞒维踢游般录另威约厘洗篮岭嫁崖泛惨功散侦洲台焦枪蒜揭捎抽寇洋益挨右盈赤港潮寄锡况贱俱竹沾严吞眼屠各堤冷衣粥把失河轧捞岩阀三鸦挠锹误布艰梯米丁峰欧桃者受丘祝光昆猾瓣全碗斤魔志弱呢挂释浑劲径樱稼纳糠胜孙闻极播顽粉家总虑悉逐娃倚卜亚虏店子培惊金愉剖谊佳斧凶难晚灌浓乔顺蚕黄驾宋班现俯紧独坝收击惑逢蝴注疤途沉愤杏西圾笼绒筋退八文庭或喊猪晶仁艇曾皆允测史朴迹罩叔承基尝嘴抓嗽轻逼众骤学厉辞医恭端属菌讨驼赛纲岂炮甩霸砖渡刮洪太牛划旁倒首哨星巩每型酒脏败汪十力捧挖乖私夕津争兆彻隐餐句膊柄依枯础幕膨束院贸凯至陡让葵叨泻葬宿赶燕如矛颜射裳伐次盗畅丹顷匠妙霉禾取接健仙摇论瓜拼科感什歌居银哈帽念殖困变杠边肠猫宫衬埋秆球强去俗疯刃巡林挽精建华袖获归乓宇懂狠赢晕梢爪禁炎痒症桥跳捷醉鸭块空州赞唉亮抖期耀扁跌秒遇汇耕乃假蜻鬼声腥催切处湿虾鞭荷珠剪掉搅愁蚂括校盾觉洽傅香对泽杆绸昏忠旺车司甚薄搏候川绞童略棋怒椒尺姨狱碑拦青欣清搁立搞征皂禽儿落玉堡呈京壁官帐解悬副御除询紫县饭违迈桑痛何盯段勇浮萝亿乘员舅你选饲周眠供蜡螺身销两蛋负著脑晋锻溪裤棵绢妈炼慕橡恋").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
    }
    @Test
    public void IT_TD_009_005_004_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","断冲刑现四自货虽嫩辛翠控境杨肾鼠最伶烂滤客筐战枪候擦逆处果更叙显壤岸城暂锋疲男化兽份乎僚珍酸统姜棉携返器哲采叮欣追陶吼向瞧议写医牵滚始胖航致券拆阅多蒸炼缴庄毅鞋基要脖将量之潜奸险充汽肩休郑冒罢柴鱼腊耀周梨部备早通萌楼绕牲丙曲旱吉具厉金膝晌乳审按辉顿海乱封掌板孝长符丛晨守例爪孩经钩泡蜓艺蓄膏拍鸟狂帜马厂庆诵卖铺鹊后涨删西荐失纺逐馆妄欧乏劳污怠史柏妹完床柜孕嘱族墓但用殿镜掩今斧匹偶述朴外味站互据抬若略县历羞王暖毯做旅俩在毕健脾麻岁庭乐茂杜烦抛吧垫整吗顷循蛙润厦场怖宅途本辞别喉答详宪狮颗渣证戚恢峡妙新督宿为干狸")
                        .param("description","迅团寺任辣钳当仙乎面惑变让搏挺伟背忍糠虹洪愿监特录践瓦燥往佣已力饱迎厦酸违嫩明意吉谎困洒桨泛羡尊实泥示律称费完私贡晨答喇鄙浸进奋座管蠢拴炮粪肆风衣妙岩辞揉额由惧斜弟跨境屋染仓都稳勇愚闹围学指煌抹处救莫失丸龙繁匠叨垂签热易舒件释筋搬援翠地帅掩帝古重抢待授否爹千孤铸库此篇中槐滥象宫警陷皂循联为咏清袖双秤麦帐久阶迟养兰盟盯罢诞好纯伸披级优技旨映秧透粮威厉垮航鞠盏九蚕非逗凳徒眠灯血捉彼贸源叹叫丝幻值返蚊萌唤京跃俭看邻声句秘臣润超极殿欺蜂炎汪屑轰洽冤铺蜘章牛拘颠抬谅乒嘉糊鸡拌滤岭标疗式产赤窄喘咸扮雕略炼果书辟臂邀戴狮赢匪丛粱公鞋扩导姓牧樱协烈怨逃印村吨府委持筑乔盗物脾绪犹舟半仗受脆检然民玻卷念笔铲坡昌劣偏培殊挠居梅谜赚万丘嫌纹庙悄案劳间艰粗做胳垄问房作缎票珠战跟毙鹊突祸后碧蛙享吼呀承糖骂斯治睬葵线路挡席钞泰细积腾时刺旗薪刮廊松柳绘扔夕胶侨盈升悼金暑剑塌黎串月我残讨灶陵译厨恐跳气钻紫宴予苗毕只卡绿教罩军太暴改附兴开欢规浆阀趁许刃旷罐逼笼云午色数渴锁争累鸽谣毯平草丹调直登摆画棚番扣交没以萍品骑傲购呈工斑箭鼠针朗慨角秆塘据雾慧阁微计仆道箱减旱疆北粥津赖者馋氏祖淹拆益来险岗肝胞弱乏越狡审湾溜菊代胸饺遵顶塔攻狗吵迷桐睡说款灰凯短叉株欧六坐贴鼓演华锻逮炒豆包从反狸亮胆弃赌芦汉总室亡良差萝自锣赵锐弓雀把赏铁终亦壤野生宣贤挽馅还迹户抚接浙膏四砍帆星扇挥普辜首派术脸将荣帽瞎乙枯锦音取尽屿事扭盐茶鲜惨秒雁伍远雅狐猎庭痰颗咬厕扰岸令随补蚁孝寸喷啄恨秀撇贞厌满督窃插艇堵驳睁底澡衰去押虎花呼住酷艺沟厘之衬俘歪犁烧愤项讯杨凑沈槽众毛虏祥吐而仅论葱裹邮猛避啦堪目悬回旋守探艘杰垦率哥博殖右拦甘扎下政富辈荡絮病雪挂辩美准等就衫菜漫吸期珍绞袍温机惕霞借榴侵恳络尚剥顾孩丧得诊社腔耻拉萄旁聚搭租溉留嗓软稼要闪脖蒙己闯潮遍拥尝缩笨骄独屈茫拳汇抽辰拣竟乳轮纠站颂镜炭送泽鞭肚结劈试贪疤兆捧唇冬梯妈础捷灌册切腿充光摧院俗李认或消纤宵姐唱壮芹诗锋辛挣度局纱郊缝井浅堂僚显闸致复责纸叙奖凡钥挎谁勾摇料评个窜压梨饮眼关转舰手煮兔材绑么徐用怎乓练寒业球枝帖容归惰启姨师趣促袜斤买默滩旬估放跑贺唯裤蓬叛宜畅研信全街汤诸韵哪伤响衔塑家鲁筛杂喜界帘娱扬耍换零米哑熟洋艳椅辫身河匹燕伐俩体橘狼善架渗虫镰昼竿麻鱼精川晓桂但肠狭赞肺洲穗谷扫林禾山种瓶甩桌芽触驻哄秩省范牺树波丙灭功拔八访霜命筐汽侮筝渡芒蝴慈帜寄桑裙役白南枕娇慎族狂般著滋孔抛痛正猴稿绳桥").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        //ResultActions perform=mockMvc.perform(builder);
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"字段长度过长，请重新修改！");
    }
    @Test
    public void IT_TD_009_005_004_002() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","断冲刑现四自货虽嫩辛翠控境杨肾鼠最伶烂滤客筐战枪候擦逆处果更叙显壤岸城暂锋疲男化兽份乎僚珍酸统姜棉携返器哲采叮欣追陶吼向瞧议写医牵滚始胖航致券拆阅多蒸炼缴庄毅鞋基要脖将量之潜奸险充汽肩休郑冒罢柴鱼腊耀周梨部备早通萌楼绕牲丙曲旱吉具厉金膝晌乳审按辉顿海乱封掌板孝长符丛晨守例爪孩经钩泡蜓艺蓄膏拍鸟狂帜马厂庆诵卖铺鹊后涨删西荐失纺逐馆妄欧乏劳污怠史柏妹完床柜孕嘱族墓但用殿镜掩今斧匹偶述朴外味站互据抬若略县历羞王暖毯做旅俩在毕健脾麻岁庭乐茂杜烦抛吧垫整吗顷循蛙润厦场怖宅途本辞别喉答详宪狮颗渣证戚恢峡妙新督宿为干狸茅")
                        .param("description","迅团寺任辣钳当仙乎面惑变让搏挺伟背忍糠虹洪愿监特录践瓦燥往佣已力饱迎厦酸违嫩明意吉谎困洒桨泛羡尊实泥示律称费完私贡晨答喇鄙浸进奋座管蠢拴炮粪肆风衣妙岩辞揉额由惧斜弟跨境屋染仓都稳勇愚闹围学指煌抹处救莫失丸龙繁匠叨垂签热易舒件释筋搬援翠地帅掩帝古重抢待授否爹千孤铸库此篇中槐滥象宫警陷皂循联为咏清袖双秤麦帐久阶迟养兰盟盯罢诞好纯伸披级优技旨映秧透粮威厉垮航鞠盏九蚕非逗凳徒眠灯血捉彼贸源叹叫丝幻值返蚊萌唤京跃俭看邻声句秘臣润超极殿欺蜂炎汪屑轰洽冤铺蜘章牛拘颠抬谅乒嘉糊鸡拌滤岭标疗式产赤窄喘咸扮雕略炼果书辟臂邀戴狮赢匪丛粱公鞋扩导姓牧樱协烈怨逃印村吨府委持筑乔盗物脾绪犹舟半仗受脆检然民玻卷念笔铲坡昌劣偏培殊挠居梅谜赚万丘嫌纹庙悄案劳间艰粗做胳垄问房作缎票珠战跟毙鹊突祸后碧蛙享吼呀承糖骂斯治睬葵线路挡席钞泰细积腾时刺旗薪刮廊松柳绘扔夕胶侨盈升悼金暑剑塌黎串月我残讨灶陵译厨恐跳气钻紫宴予苗毕只卡绿教罩军太暴改附兴开欢规浆阀趁许刃旷罐逼笼云午色数渴锁争累鸽谣毯平草丹调直登摆画棚番扣交没以萍品骑傲购呈工斑箭鼠针朗慨角秆塘据雾慧阁微计仆道箱减旱疆北粥津赖者馋氏祖淹拆益来险岗肝胞弱乏越狡审湾溜菊代胸饺遵顶塔攻狗吵迷桐睡说款灰凯短叉株欧六坐贴鼓演华锻逮炒豆包从反狸亮胆弃赌芦汉总室亡良差萝自锣赵锐弓雀把赏铁终亦壤野生宣贤挽馅还迹户抚接浙膏四砍帆星扇挥普辜首派术脸将荣帽瞎乙枯锦音取尽屿事扭盐茶鲜惨秒雁伍远雅狐猎庭痰颗咬厕扰岸令随补蚁孝寸喷啄恨秀撇贞厌满督窃插艇堵驳睁底澡衰去押虎花呼住酷艺沟厘之衬俘歪犁烧愤项讯杨凑沈槽众毛虏祥吐而仅论葱裹邮猛避啦堪目悬回旋守探艘杰垦率哥博殖右拦甘扎下政富辈荡絮病雪挂辩美准等就衫菜漫吸期珍绞袍温机惕霞借榴侵恳络尚剥顾孩丧得诊社腔耻拉萄旁聚搭租溉留嗓软稼要闪脖蒙己闯潮遍拥尝缩笨骄独屈茫拳汇抽辰拣竟乳轮纠站颂镜炭送泽鞭肚结劈试贪疤兆捧唇冬梯妈础捷灌册切腿充光摧院俗李认或消纤宵姐唱壮芹诗锋辛挣度局纱郊缝井浅堂僚显闸致复责纸叙奖凡钥挎谁勾摇料评个窜压梨饮眼关转舰手煮兔材绑么徐用怎乓练寒业球枝帖容归惰启姨师趣促袜斤买默滩旬估放跑贺唯裤蓬叛宜畅研信全街汤诸韵哪伤响衔塑家鲁筛杂喜界帘娱扬耍换零米哑熟洋艳椅辫身河匹燕伐俩体橘狼善架渗虫镰昼竿麻鱼精川晓桂但肠狭赞肺洲穗谷扫林禾山种瓶甩桌芽触驻哄秩省范牺树波丙灭功拔八访霜命筐汽侮筝渡芒蝴慈帜寄桑裙役白南枕娇慎族狂般著滋孔抛痛正猴稿绳").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        //ResultActions perform=mockMvc.perform(builder);
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"字段长度过长，请重新修改！");
    }
    @Test
    public void IT_TD_009_006_001_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address","煮友筹挨球悉吴秆废惊央微睁挣愤章锤野卷物岩碎六鸦派塔宣递驾辉山稠嘱标筝醒拾办增撒汽愉彼游职书蚁诱槐妄鸽碗阵翼傲员酷测锁雁捞潮陵宰揉鸭任暑材雪供究常绑节诊笼北林龙境紧板认旦骨逃桂抱仔喇炸理狼尸齐作集短叔悬扯俊摧规宇孟旗走抢挤博困窄站么曾驴扩伏亚向侮顺瓣弹劲切录判甘兵页聪阿锹骂朋评说膏算钻亭苏兼推似凯育街吐恢社窜确郎袄锣位眉息忧生贵暗保扒纤赴晕暴蜡皱寺不女忆勺男解货弊榜剑扭催熊漠话定治橡雷恩真漆默路德牧井涂胖茎毛高峡倦抽饱曲绿退取苗筋拨种朵县拼笛夕负轨语巴矩啄筒区艰初龟蕉钱字缴木柿更务斥诚改和辛刘除蜂距渡蒜垫朴")
                        .param("description","蠢初属基咐汉淹后者两穴窃救军蜓拴把造绘崖进济效治整貌危女质挠愁晓哭律闯每垦桥往送欣岔呈启厅第巾赖想哑舍沸材扁老寨换梦脏分督核拥歼匪状宁镰达衔办杀毕毁井器修鲜扎照络势派弃埋筐隶群壮坏拣锡风柳垂划满泼沉授源仿遣尼购重企毛存控帘抓跨平为因命八固玉适元没肃侍殖迅庆们追波燥烈掩逐谜嗓陈影甩傅枣扯惹转泥龟钩洽详眯欧悲扒视哗乞瞒胜库阶茎板教你采读熄盛干绍劫犁楚韵卷短醒选赛警呜梯带地蛇小糖一袄谷燃债装醉粮裁谅语愚屑讯销绢械种否花机蓄津睁眨竭虽差俱誉年软颗哥个辛煮罗秩敲骄争城孝表响肯泉雁吓果膛纠道奴度名就裂截辨注衰饮围锅索昏蕉唯戒点剂亡莲育失巧幕渐鞋承雾陆车麻幸绩高宿务代诊孔摊圆椅夕僻嗽湾驾尿气让窗稳宵告始段耍唇摸俊妹标吞阁厂辆膀赠痛炼阻降赵舟橘斯糠支宗浑恭题佩书卡轮婶背漫半犯冬雀敬冶父等桐维喉崭矩领穿赢狂哲例竞誓斧扶忘粥悠拖友总缓殃丝受累方哀拍森域香护兼墓顷窝顿右摄胶子邮阿盗垫芽脉枯讽隐慕织吴尽斩纺皮忍船蒙菠劣秋锈稼藏查扑浇嘉塞品最组单故杯土几辣膏鹰芒辜序烫校寺庭自帝沟筒敌逝朴协客骨喷广托岩三夜狸露慰诚愿填挖纪出外少遭腹田龄珠链操裤奥室徒恳纸巡掘看破混率祸窑潜垒认穷吼拒宽儿呆吨舅弱乖倦佛档怕急睡脸亦师州拐豆柿暴估略咏漂断除弹无垄蜜类即翼余违演僚绳氏忙积俯览则二蛛乐服梁金泛坊梳趴峡贞以串扬十旺象仅颂致从锤剪锣定覆万冰滨屈据纹歉勇辰按递捞翠渔罩帖丽横快弟枕巷乡葱望溪包袭币悟挂晕堵撑洪江士颠赔竿捏膝晨竟臭酱袜远堡长孕声工孩刀世撒絮鸣感跪较予锐占役脊议愧循罚纱力霸熔姑兵沈倘址萝投续魄良昼握凉聋蚊敞那去硬卫挺唱佣甜君担如事连负步奔悔耀萄细压阴麦艘西量驶饰星闷逢若申凶胳壳轻错肚双症丈厚贺插忆被赏诉饼匙相王作迈烛恼趟草凑芦应礼帮货尊筛劲坐灾灵渠卵浴贫泽亏票烟惯河秘闭欺巴暂志泊神荣文才油根忠傻蹲排传愈豪培啊叛潮怀竖译腥秒纽浙狱晋痰页向丘棵钱踪贷慨铲委铃袖斗晒售咱挨描糊炎厨稀朱置端寻周罢李什静团喜秤雷病吧猫恰堆绪示取好鸡腔张哈宝多己伏渗轰驼浆昌兆赞汇共婚笛涨对驱盘跳判还窄歇咽红凝副德但季浪番碑钉盲永丸击福旁患馋撕仗路俘嘱恋久买刷内宏完吹前舒性吩狡稍冈肩逼松或牢街般菌馅温碰拌滑试折恩院精推惩遇评暗欠这黄左榆义罪害侄漠铅睬样贿驰泳砖孙活祖枝傲归它丹赴本娘衬桨瓶在缴壶蓝翁反参汗蓬虑拳奖克汤么叹目习锋羡汽纵昨却寄蜡起桑奇懒涉套慈缝彼建挽爆凤骡忽仔储蚁消捎专妈圣荒酷此雕畏乓棋色蝴尾羊膜侦芹嚷晃饲朋砌锻膊竹雄岁忧").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");
        //ResultActions perform=mockMvc.perform(builder);
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"venueID不存在!");
       // perform.andExpect(redirectedUrl("venue_manage"));
    }
    @Test
    public void IT_TD_009_006_002_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address","煮友筹挨球悉吴秆废惊央微睁挣愤章锤野卷物岩碎六鸦派塔宣递驾辉山稠嘱标筝醒拾办增撒汽愉彼游职书蚁诱槐妄鸽碗阵翼傲员酷测锁雁捞潮陵宰揉鸭任暑材雪供究常绑节诊笼北林龙境紧板认旦骨逃桂抱仔喇炸理狼尸齐作集短叔悬扯俊摧规宇孟旗走抢挤博困窄站么曾驴扩伏亚向侮顺瓣弹劲切录判甘兵页聪阿锹骂朋评说膏算钻亭苏兼推似凯育街吐恢社窜确郎袄锣位眉息忧生贵暗保扒纤赴晕暴蜡皱寺不女忆勺男解货弊榜剑扭催熊漠话定治橡雷恩真漆默路德牧井涂胖茎毛高峡倦抽饱曲绿退取苗筋拨种朵县拼笛夕负轨语巴矩啄筒区艰初龟蕉钱字缴木柿更务斥诚改和辛刘除蜂距渡蒜垫朴")
                        .param("description","蠢初属基咐汉淹后者两穴窃救军蜓拴把造绘崖进济效治整貌危女质挠愁晓哭律闯每垦桥往送欣岔呈启厅第巾赖想哑舍沸材扁老寨换梦脏分督核拥歼匪状宁镰达衔办杀毕毁井器修鲜扎照络势派弃埋筐隶群壮坏拣锡风柳垂划满泼沉授源仿遣尼购重企毛存控帘抓跨平为因命八固玉适元没肃侍殖迅庆们追波燥烈掩逐谜嗓陈影甩傅枣扯惹转泥龟钩洽详眯欧悲扒视哗乞瞒胜库阶茎板教你采读熄盛干绍劫犁楚韵卷短醒选赛警呜梯带地蛇小糖一袄谷燃债装醉粮裁谅语愚屑讯销绢械种否花机蓄津睁眨竭虽差俱誉年软颗哥个辛煮罗秩敲骄争城孝表响肯泉雁吓果膛纠道奴度名就裂截辨注衰饮围锅索昏蕉唯戒点剂亡莲育失巧幕渐鞋承雾陆车麻幸绩高宿务代诊孔摊圆椅夕僻嗽湾驾尿气让窗稳宵告始段耍唇摸俊妹标吞阁厂辆膀赠痛炼阻降赵舟橘斯糠支宗浑恭题佩书卡轮婶背漫半犯冬雀敬冶父等桐维喉崭矩领穿赢狂哲例竞誓斧扶忘粥悠拖友总缓殃丝受累方哀拍森域香护兼墓顷窝顿右摄胶子邮阿盗垫芽脉枯讽隐慕织吴尽斩纺皮忍船蒙菠劣秋锈稼藏查扑浇嘉塞品最组单故杯土几辣膏鹰芒辜序烫校寺庭自帝沟筒敌逝朴协客骨喷广托岩三夜狸露慰诚愿填挖纪出外少遭腹田龄珠链操裤奥室徒恳纸巡掘看破混率祸窑潜垒认穷吼拒宽儿呆吨舅弱乖倦佛档怕急睡脸亦师州拐豆柿暴估略咏漂断除弹无垄蜜类即翼余违演僚绳氏忙积俯览则二蛛乐服梁金泛坊梳趴峡贞以串扬十旺象仅颂致从锤剪锣定覆万冰滨屈据纹歉勇辰按递捞翠渔罩帖丽横快弟枕巷乡葱望溪包袭币悟挂晕堵撑洪江士颠赔竿捏膝晨竟臭酱袜远堡长孕声工孩刀世撒絮鸣感跪较予锐占役脊议愧循罚纱力霸熔姑兵沈倘址萝投续魄良昼握凉聋蚊敞那去硬卫挺唱佣甜君担如事连负步奔悔耀萄细压阴麦艘西量驶饰星闷逢若申凶胳壳轻错肚双症丈厚贺插忆被赏诉饼匙相王作迈烛恼趟草凑芦应礼帮货尊筛劲坐灾灵渠卵浴贫泽亏票烟惯河秘闭欺巴暂志泊神荣文才油根忠傻蹲排传愈豪培啊叛潮怀竖译腥秒纽浙狱晋痰页向丘棵钱踪贷慨铲委铃袖斗晒售咱挨描糊炎厨稀朱置端寻周罢李什静团喜秤雷病吧猫恰堆绪示取好鸡腔张哈宝多己伏渗轰驼浆昌兆赞汇共婚笛涨对驱盘跳判还窄歇咽红凝副德但季浪番碑钉盲永丸击福旁患馋撕仗路俘嘱恋久买刷内宏完吹前舒性吩狡稍冈肩逼松或牢街般菌馅温碰拌滑试折恩院精推惩遇评暗欠这黄左榆义罪害侄漠铅睬样贿驰泳砖孙活祖枝傲归它丹赴本娘衬桨瓶在缴壶蓝翁反参汗蓬虑拳奖克汤么叹目习锋羡汽纵昨却寄蜡起桑奇懒涉套慈缝彼建挽爆凤骡忽仔储蚁消捎专妈圣荒酷此雕畏乓棋色蝴尾羊膜侦芹嚷晃饲朋砌锻膊竹雄岁忧").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");
        //ResultActions perform=mockMvc.perform(builder);
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"venueID不存在!");
        // perform.andExpect(redirectedUrl("venue_manage"));
    }
    @Test
    public void IT_TD_009_006_003_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","29").param("venueName","venue").param("address","煮友筹挨球悉吴秆废惊央微睁挣愤章锤野卷物岩碎六鸦派塔宣递辉山稠嘱标筝醒拾办增撒汽愉彼游职书蚁诱槐妄鸽碗阵翼傲员酷测锁雁捞潮陵宰揉鸭任暑材雪供究常绑节诊笼北林龙境紧板认旦骨逃桂抱仔喇炸理狼尸齐作集短叔悬扯俊摧规宇孟旗走抢挤博困窄站么曾驴扩伏亚向侮顺瓣弹劲切录判甘兵页聪阿锹骂朋评说膏算钻亭苏兼推似凯育街吐恢社窜确郎袄锣位眉息忧生贵暗保扒纤赴晕暴蜡皱寺不女忆勺男解货弊榜剑扭催熊漠话定治橡雷恩真漆默路德牧井涂胖茎毛高峡倦抽饱曲绿退取苗筋拨种朵县拼笛夕负轨语巴矩啄筒区艰初龟蕉钱字缴木柿更务斥诚改和辛刘除蜂距渡蒜垫朴")
                        .param("description","蠢初属基咐汉淹后者两穴窃救军蜓拴把造绘崖进济效治整貌危女质挠愁晓哭律闯每垦桥往送欣岔呈启厅第巾赖想哑舍沸材扁老寨换梦脏分督核拥歼匪状宁镰达衔办杀毕毁井器修鲜扎照络势派弃埋筐隶群壮坏拣锡风柳垂划满泼沉授源仿遣尼购重企毛存控帘抓跨平为因命八固玉适元没肃侍殖迅庆们追波燥烈掩逐谜嗓陈影甩傅枣扯惹转泥龟钩洽详眯欧悲扒视哗乞瞒胜库阶茎板教你采读熄盛干绍劫犁楚韵卷短醒选赛警呜梯带地蛇小糖一袄谷燃债装醉粮裁谅语愚屑讯销绢械种否花机蓄津睁眨竭虽差俱誉年软颗哥个辛煮罗秩敲骄争城孝表响肯泉雁吓果膛纠道奴度名就裂截辨注衰饮围锅索昏蕉唯戒点剂亡莲育失巧幕渐鞋承雾陆车麻幸绩高宿务代诊孔摊圆椅夕僻嗽湾驾尿气让窗稳宵告始段耍唇摸俊妹标吞阁厂辆膀赠痛炼阻降赵舟橘斯糠支宗浑恭题佩书卡轮婶背漫半犯冬雀敬冶父等桐维喉崭矩领穿赢狂哲例竞誓斧扶忘粥悠拖友总缓殃丝受累方哀拍森域香护兼墓顷窝顿右摄胶子邮阿盗垫芽脉枯讽隐慕织吴尽斩纺皮忍船蒙菠劣秋锈稼藏查扑浇嘉塞品最组单故杯土几辣膏鹰芒辜序烫校寺庭自帝沟筒敌逝朴协客骨喷广托岩三夜狸露慰诚愿填挖纪出外少遭腹田龄珠链操裤奥室徒恳纸巡掘看破混率祸窑潜垒认穷吼拒宽儿呆吨舅弱乖倦佛档怕急睡脸亦师州拐豆柿暴估略咏漂断除弹无垄蜜类即翼余违演僚绳氏忙积俯览则二蛛乐服梁金泛坊梳趴峡贞以串扬十旺象仅颂致从锤剪锣定覆万冰滨屈据纹歉勇辰按递捞翠渔罩帖丽横快弟枕巷乡葱望溪包袭币悟挂晕堵撑洪江士颠赔竿捏膝晨竟臭酱袜远堡长孕声工孩刀世撒絮鸣感跪较予锐占役脊议愧循罚纱力霸熔姑兵沈倘址萝投续魄良昼握凉聋蚊敞那去硬卫挺唱佣甜君担如事连负步奔悔耀萄细压阴麦艘西量驶饰星闷逢若申凶胳壳轻错肚双症丈厚贺插忆被赏诉饼匙相王作迈烛恼趟草凑芦应礼帮货尊筛劲坐灾灵渠卵浴贫泽亏票烟惯河秘闭欺巴暂志泊神荣文才油根忠傻蹲排传愈豪培啊叛潮怀竖译腥秒纽浙狱晋痰页向丘棵钱踪贷慨铲委铃袖斗晒售咱挨描糊炎厨稀朱置端寻周罢李什静团喜秤雷病吧猫恰堆绪示取好鸡腔张哈宝多己伏渗轰驼浆昌兆赞汇共婚笛涨对驱盘跳判还窄歇咽红凝副德但季浪番碑钉盲永丸击福旁患馋撕仗路俘嘱恋久买刷内宏完吹前舒性吩狡稍冈肩逼松或牢街般菌馅温碰拌滑试折恩院精推惩遇评暗欠这黄左榆义罪害侄漠铅睬样贿驰泳砖孙活祖枝傲归它丹赴本娘衬桨瓶在缴壶蓝翁反参汗蓬虑拳奖克汤么叹目习锋羡汽纵昨却寄蜡起桑奇懒涉套慈缝彼建挽爆凤骡忽仔储蚁消捎专妈圣荒酷此雕畏乓棋色蝴尾羊膜侦芹嚷晃饲朋砌锻膊竹雄岁忧").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");
        //ResultActions perform=mockMvc.perform(builder);
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"字段长度过长，请重新修改！");
        // perform.andExpect(redirectedUrl("venue_manage"));
    }
    @Test
    public void IT_TD_009_006_004_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address","煮友筹挨球吴秆废惊央微睁挣愤章锤野卷物岩碎六鸦派塔宣递驾辉山稠嘱标筝醒拾办增撒汽愉彼游职书蚁诱槐妄鸽碗阵翼傲员酷测锁雁捞潮陵宰揉鸭任暑材雪供究常绑节诊笼北林龙境紧板认旦骨逃桂抱仔喇炸理狼尸齐作集短叔悬扯俊摧规宇孟旗走抢挤博困窄站么曾驴扩伏亚向侮顺瓣弹劲切录判甘兵页聪阿锹骂朋评说膏算钻亭苏兼推似凯育街吐恢社窜确郎袄锣位眉息忧生贵暗保扒纤赴晕暴蜡皱寺不女忆勺男解货弊榜剑扭催熊漠话定治橡雷恩真漆默路德牧井涂胖茎毛高峡倦抽饱曲绿退取苗筋拨种朵县拼笛夕负轨语巴矩啄筒区艰初龟蕉钱字缴木柿更务斥诚改和辛刘除蜂距渡蒜垫朴")
                        .param("description","蠢初属基咐汉淹后者两穴窃救军蜓拴把造绘崖进济效治整貌危女质挠愁晓哭律闯每垦桥往送欣岔呈启厅第巾赖想哑舍沸材扁老寨换梦脏分督核拥歼匪状宁镰达衔办杀毕毁井器修鲜扎照络势派弃埋筐隶群壮坏拣锡风柳垂划满泼沉授源仿遣尼购重企毛存控帘抓跨平为因命八固玉适元没肃侍殖迅庆们追波燥烈掩逐谜嗓陈影甩傅枣扯惹转泥龟钩洽详眯欧悲扒视哗乞瞒胜库阶茎板教你采读熄盛干绍劫犁楚韵卷短醒选赛警呜梯带地蛇小糖一袄谷燃债装醉粮裁谅语愚屑讯销绢械种否花机蓄津睁眨竭虽差俱誉年软颗哥个辛煮罗秩敲骄争城孝表响肯泉雁吓果膛纠道奴度名就裂截辨注衰饮围锅索昏蕉唯戒点剂亡莲育失巧幕渐鞋承雾陆车麻幸绩高宿务代诊孔摊圆椅夕僻嗽湾驾尿气让窗稳宵告始段耍唇摸俊妹标吞阁厂辆膀赠痛炼阻降赵舟橘斯糠支宗浑恭题佩书卡轮婶背漫半犯冬雀敬冶父等桐维喉崭矩领穿赢狂哲例竞誓斧扶忘粥悠拖友总缓殃丝受累方哀拍森域香护兼墓顷窝顿右摄胶子邮阿盗垫芽脉枯讽隐慕织吴尽斩纺皮忍船蒙菠劣秋锈稼藏查扑浇嘉塞品最组单故杯土几辣膏鹰芒辜序烫校寺庭自帝沟筒敌逝朴协客骨喷广托岩三夜狸露慰诚愿填挖纪出外少遭腹田龄珠链操裤奥室徒恳纸巡掘看破混率祸窑潜垒认穷吼拒宽儿呆吨舅弱乖倦佛档怕急睡脸亦师州拐豆柿暴估略咏漂断除弹无垄蜜类即翼余违演僚绳氏忙积俯览则二蛛乐服梁金泛坊梳趴峡贞以串扬十旺象仅颂致从锤剪锣定覆万冰滨屈据纹歉勇辰按递捞翠渔罩帖丽横快弟枕巷乡葱望溪包袭币悟挂晕堵撑洪江士颠赔竿捏膝晨竟臭酱袜远堡长孕声工孩刀世撒絮鸣感跪较予锐占役脊议愧循罚纱力霸熔姑兵沈倘址萝投续魄良昼握凉聋蚊敞那去硬卫挺唱佣甜君担如事连负步奔悔耀萄细压阴麦艘西量驶饰星闷逢若申凶胳壳轻错肚双症丈厚贺插忆被赏诉饼匙相王作迈烛恼趟草凑芦应礼帮货尊筛劲坐灾灵渠卵浴贫泽亏票烟惯河秘闭欺巴暂志泊神荣文才油根忠傻蹲排传愈豪培啊叛潮怀竖译腥秒纽浙狱晋痰页向丘棵钱踪贷慨铲委铃袖斗晒售咱挨描糊炎厨稀朱置端寻周罢李什静团喜秤雷病吧猫恰堆绪示取好鸡腔张哈宝多己伏渗轰驼浆昌兆赞汇共婚笛涨对驱盘跳判还窄歇咽红凝副德但季浪番碑钉盲永丸击福旁患馋撕仗路俘嘱恋久买刷内宏完吹前舒性吩狡稍冈肩逼松或牢街般菌馅温碰拌滑试折恩院精推惩遇评暗欠这黄左榆义罪害侄漠铅睬样贿驰泳砖孙活祖枝傲归它丹赴本娘衬桨瓶在缴壶蓝翁反参汗蓬虑拳奖克汤么叹目习锋羡汽纵昨却寄蜡起桑奇懒涉套慈缝彼建挽爆凤骡忽仔储蚁消捎专妈圣荒酷此雕畏乓棋色蝴尾羊膜侦芹嚷晃饲朋砌锻膊竹雄岁忧").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");
        //ResultActions perform=mockMvc.perform(builder);
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"venueID不存在!");
        // perform.andExpect(redirectedUrl("venue_manage"));
    }
    @Test
    public void IT_TD_009_006_005_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","29").param("venueName","venue").param("address","冻奸吞宇算不鹿龄嚷柔蓝执崖弱红赢危毯蔑塔爸桑壮毛背糕婚悟绞摄舌去嫂睬缩赚炒寨旱约狼扑夕戏右槐钢域桐很躁乱京衔态洞呼住龙随宰陕忧缝劈筐鼓笔秆音醋箩降踩雀类增宴胃蜜宵混智聪全厅字绢割沟茧咬沃稻院矩替巧云没着昂典光驾剖还膀治欠础熊桌研芽讨拖球植呆霸歼调魄鸭胖壳剥某疲抬跨深松嘉解怕吊造界届罚型助豆探未那萌庭充期袄扒苗像傍秀轮辱暖惯害释崭糟竭号持穷坟膏懂什衡孕瓦制丁攻仪记亲涨狸鞋贝芝慢尼莲基区整慧称牧铜杠庸永削遵夜善风搁钳棉眨武抗阻宫肤绝决趋疗纹僚圣酒归登份应恭够保拐使恩酿喂艰连次哑稠报由特捉你芳蚕菠坚配职负苍店赶敢")
                        .param("description","蠢初属基咐汉后者两穴窃救军蜓拴把造绘崖进济效治整貌危女质挠愁晓哭律闯每垦桥往送欣岔呈启厅第巾赖想哑舍沸材扁老寨换梦脏分督核拥歼匪状宁镰达衔办杀毕毁井器修鲜扎照络势派弃埋筐隶群壮坏拣锡风柳垂划满泼沉授源仿遣尼购重企毛存控帘抓跨平为因命八固玉适元没肃侍殖迅庆们追波燥烈掩逐谜嗓陈影甩傅枣扯惹转泥龟钩洽详眯欧悲扒视哗乞瞒胜库阶茎板教你采读熄盛干绍劫犁楚韵卷短醒选赛警呜梯带地蛇小糖一袄谷燃债装醉粮裁谅语愚屑讯销绢械种否花机蓄津睁眨竭虽差俱誉年软颗哥个辛煮罗秩敲骄争城孝表响肯泉雁吓果膛纠道奴度名就裂截辨注衰饮围锅索昏蕉唯戒点剂亡莲育失巧幕渐鞋承雾陆车麻幸绩高宿务代诊孔摊圆椅夕僻嗽湾驾尿气让窗稳宵告始段耍唇摸俊妹标吞阁厂辆膀赠痛炼阻降赵舟橘斯糠支宗浑恭题佩书卡轮婶背漫半犯冬雀敬冶父等桐维喉崭矩领穿赢狂哲例竞誓斧扶忘粥悠拖友总缓殃丝受累方哀拍森域香护兼墓顷窝顿右摄胶子邮阿盗垫芽脉枯讽隐慕织吴尽斩纺皮忍船蒙菠劣秋锈稼藏查扑浇嘉塞品最组单故杯土几辣膏鹰芒辜序烫校寺庭自帝沟筒敌逝朴协客骨喷广托岩三夜狸露慰诚愿填挖纪出外少遭腹田龄珠链操裤奥室徒恳纸巡掘看破混率祸窑潜垒认穷吼拒宽儿呆吨舅弱乖倦佛档怕急睡脸亦师州拐豆柿暴估略咏漂断除弹无垄蜜类即翼余违演僚绳氏忙积俯览则二蛛乐服梁金泛坊梳趴峡贞以串扬十旺象仅颂致从锤剪锣定覆万冰滨屈据纹歉勇辰按递捞翠渔罩帖丽横快弟枕巷乡葱望溪包袭币悟挂晕堵撑洪江士颠赔竿捏膝晨竟臭酱袜远堡长孕声工孩刀世撒絮鸣感跪较予锐占役脊议愧循罚纱力霸熔姑兵沈倘址萝投续魄良昼握凉聋蚊敞那去硬卫挺唱佣甜君担如事连负步奔悔耀萄细压阴麦艘西量驶饰星闷逢若申凶胳壳轻错肚双症丈厚贺插忆被赏诉饼匙相王作迈烛恼趟草凑芦应礼帮货尊筛劲坐灾灵渠卵浴贫泽亏票烟惯河秘闭欺巴暂志泊神荣文才油根忠傻蹲排传愈豪培啊叛潮怀竖译腥秒纽浙狱晋痰页向丘棵钱踪贷慨铲委铃袖斗晒售咱挨描糊炎厨稀朱置端寻周罢李什静团喜秤雷病吧猫恰堆绪示取好鸡腔张哈宝多己伏渗轰驼浆昌兆赞汇共婚笛涨对驱盘跳判还窄歇咽红凝副德但季浪番碑钉盲永丸击福旁患馋撕仗路俘嘱恋久买刷内宏完吹前舒性吩狡稍冈肩逼松或牢街般菌馅温碰拌滑试折恩院精推惩遇评暗欠这黄左榆义罪害侄漠铅睬样贿驰泳砖孙活祖枝傲归它丹赴本娘衬桨瓶在缴壶蓝翁反参汗蓬虑拳奖克汤么叹目习锋羡汽纵昨却寄蜡起桑奇懒涉套慈缝彼建挽爆凤骡忽仔储蚁消捎专妈圣荒酷此雕畏乓棋色蝴尾羊膜侦芹嚷晃饲朋砌锻膊竹雄岁忧").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"字段长度过长，请重新修改！");

    }
    @Test
    public void IT_TD_009_006_006_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address","煮友筹挨球悉吴秆废惊央微睁挣愤章锤野卷物岩碎六鸦派塔宣递驾辉山稠嘱标筝醒拾办增撒汽愉彼游职书蚁诱槐妄鸽碗阵翼傲员酷测锁雁捞潮陵宰揉鸭任暑材雪供究常绑节诊笼北林龙境紧板认旦骨逃桂抱仔喇炸理狼尸齐作集短叔悬扯俊摧规宇孟旗走抢挤博困窄站么曾驴扩伏亚向侮顺瓣弹劲切录判甘兵页聪阿锹骂朋评说膏算钻亭苏兼推似凯育街吐恢社窜确郎袄锣位眉息忧生贵暗保扒纤赴晕暴蜡皱寺不女忆勺男解货弊榜剑扭催熊漠话定治橡雷恩真漆默路德牧井涂胖茎毛高峡倦抽饱曲绿退取苗筋拨种朵县拼笛夕负轨语巴矩啄筒区艰初龟蕉钱字缴木柿更务斥诚改和辛刘除蜂距渡蒜垫朴")
                        .param("description","蠢初属基咐汉后者两穴窃救军蜓拴把造绘崖进济效治整貌危女质挠愁晓哭律闯每垦桥往送欣岔呈启厅第巾赖想哑舍沸材扁老寨换梦脏分督核拥歼匪状宁镰达衔办杀毕毁井器修鲜扎照络势派弃埋筐隶群壮坏拣锡风柳垂划满泼沉授源仿遣尼购重企毛存控帘抓跨平为因命八固玉适元没肃侍殖迅庆们追波燥烈掩逐谜嗓陈影甩傅枣扯惹转泥龟钩洽详眯欧悲扒视哗乞瞒胜库阶茎板教你采读熄盛干绍劫犁楚韵卷短醒选赛警呜梯带地蛇小糖一袄谷燃债装醉粮裁谅语愚屑讯销绢械种否花机蓄津睁眨竭虽差俱誉年软颗哥个辛煮罗秩敲骄争城孝表响肯泉雁吓果膛纠道奴度名就裂截辨注衰饮围锅索昏蕉唯戒点剂亡莲育失巧幕渐鞋承雾陆车麻幸绩高宿务代诊孔摊圆椅夕僻嗽湾驾尿气让窗稳宵告始段耍唇摸俊妹标吞阁厂辆膀赠痛炼阻降赵舟橘斯糠支宗浑恭题佩书卡轮婶背漫半犯冬雀敬冶父等桐维喉崭矩领穿赢狂哲例竞誓斧扶忘粥悠拖友总缓殃丝受累方哀拍森域香护兼墓顷窝顿右摄胶子邮阿盗垫芽脉枯讽隐慕织吴尽斩纺皮忍船蒙菠劣秋锈稼藏查扑浇嘉塞品最组单故杯土几辣膏鹰芒辜序烫校寺庭自帝沟筒敌逝朴协客骨喷广托岩三夜狸露慰诚愿填挖纪出外少遭腹田龄珠链操裤奥室徒恳纸巡掘看破混率祸窑潜垒认穷吼拒宽儿呆吨舅弱乖倦佛档怕急睡脸亦师州拐豆柿暴估略咏漂断除弹无垄蜜类即翼余违演僚绳氏忙积俯览则二蛛乐服梁金泛坊梳趴峡贞以串扬十旺象仅颂致从锤剪锣定覆万冰滨屈据纹歉勇辰按递捞翠渔罩帖丽横快弟枕巷乡葱望溪包袭币悟挂晕堵撑洪江士颠赔竿捏膝晨竟臭酱袜远堡长孕声工孩刀世撒絮鸣感跪较予锐占役脊议愧循罚纱力霸熔姑兵沈倘址萝投续魄良昼握凉聋蚊敞那去硬卫挺唱佣甜君担如事连负步奔悔耀萄细压阴麦艘西量驶饰星闷逢若申凶胳壳轻错肚双症丈厚贺插忆被赏诉饼匙相王作迈烛恼趟草凑芦应礼帮货尊筛劲坐灾灵渠卵浴贫泽亏票烟惯河秘闭欺巴暂志泊神荣文才油根忠傻蹲排传愈豪培啊叛潮怀竖译腥秒纽浙狱晋痰页向丘棵钱踪贷慨铲委铃袖斗晒售咱挨描糊炎厨稀朱置端寻周罢李什静团喜秤雷病吧猫恰堆绪示取好鸡腔张哈宝多己伏渗轰驼浆昌兆赞汇共婚笛涨对驱盘跳判还窄歇咽红凝副德但季浪番碑钉盲永丸击福旁患馋撕仗路俘嘱恋久买刷内宏完吹前舒性吩狡稍冈肩逼松或牢街般菌馅温碰拌滑试折恩院精推惩遇评暗欠这黄左榆义罪害侄漠铅睬样贿驰泳砖孙活祖枝傲归它丹赴本娘衬桨瓶在缴壶蓝翁反参汗蓬虑拳奖克汤么叹目习锋羡汽纵昨却寄蜡起桑奇懒涉套慈缝彼建挽爆凤骡忽仔储蚁消捎专妈圣荒酷此雕畏乓棋色蝴尾羊膜侦芹嚷晃饲朋砌锻膊竹雄岁忧").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");
        //ResultActions perform=mockMvc.perform(builder);
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"venueID不存在!");
        // perform.andExpect(redirectedUrl("venue_manage"));
    }
    @Test
    public void IT_TD_009_006_007_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","29").param("venueName","venue").param("address","煮友筹挨球悉吴秆废惊央微睁挣愤章锤卷物岩碎六鸦派塔宣递驾辉山稠嘱标筝醒拾办增撒汽愉彼游职书蚁诱槐妄鸽碗阵翼傲员酷测锁雁捞潮陵宰揉鸭任暑材雪供究常绑节诊笼北林龙境紧板认旦骨逃桂抱仔喇炸理狼尸齐作集短叔悬扯俊摧规宇孟旗走抢挤博困窄站么曾驴扩伏亚向侮顺瓣弹劲切录判甘兵页聪阿锹骂朋评说膏算钻亭苏兼推似凯育街吐恢社窜确郎袄锣位眉息忧生贵暗保扒纤赴晕暴蜡皱寺不女忆勺男解货弊榜剑扭催熊漠话定治橡雷恩真漆默路德牧井涂胖茎毛高峡倦抽饱曲绿退取苗筋拨种朵县拼笛夕负轨语巴矩啄筒区艰初龟蕉钱字缴木柿更务斥诚改和辛刘除蜂距渡蒜垫朴")
                        .param("description","蠢初属基咐汉后者两穴窃救军蜓拴把造绘崖进济效治整貌危女质挠愁晓哭律闯每垦桥往送欣岔呈启厅第巾赖想哑舍沸材扁老寨换梦脏分督核拥歼匪状宁镰达衔办杀毕毁井器修鲜扎照络势派弃埋筐隶群壮坏拣锡风柳垂划满泼沉授源仿遣尼购重企毛存控帘抓跨平为因命八固玉适元没肃侍殖迅庆们追波燥烈掩逐谜嗓陈影甩傅枣扯惹转泥龟钩洽详眯欧悲扒视哗乞瞒胜库阶茎板教你采读熄盛干绍劫犁楚韵卷短醒选赛警呜梯带地蛇小糖一袄谷燃债装醉粮裁谅语愚屑讯销绢械种否花机蓄津睁眨竭虽差俱誉年软颗哥个辛煮罗秩敲骄争城孝表响肯泉雁吓果膛纠道奴度名就裂截辨注衰饮围锅索昏蕉唯戒点剂亡莲育失巧幕渐鞋承雾陆车麻幸绩高宿务代诊孔摊圆椅夕僻嗽湾驾尿气让窗稳宵告始段耍唇摸俊妹标吞阁厂辆膀赠痛炼阻降赵舟橘斯糠支宗浑恭题佩书卡轮婶背漫半犯冬雀敬冶父等桐维喉崭矩领穿赢狂哲例竞誓斧扶忘粥悠拖友总缓殃丝受累方哀拍森域香护兼墓顷窝顿右摄胶子邮阿盗垫芽脉枯讽隐慕织吴尽斩纺皮忍船蒙菠劣秋锈稼藏查扑浇嘉塞品最组单故杯土几辣膏鹰芒辜序烫校寺庭自帝沟筒敌逝朴协客骨喷广托岩三夜狸露慰诚愿填挖纪出外少遭腹田龄珠链操裤奥室徒恳纸巡掘看破混率祸窑潜垒认穷吼拒宽儿呆吨舅弱乖倦佛档怕急睡脸亦师州拐豆柿暴估略咏漂断除弹无垄蜜类即翼余违演僚绳氏忙积俯览则二蛛乐服梁金泛坊梳趴峡贞以串扬十旺象仅颂致从锤剪锣定覆万冰滨屈据纹歉勇辰按递捞翠渔罩帖丽横快弟枕巷乡葱望溪包袭币悟挂晕堵撑洪江士颠赔竿捏膝晨竟臭酱袜远堡长孕声工孩刀世撒絮鸣感跪较予锐占役脊议愧循罚纱力霸熔姑兵沈倘址萝投续魄良昼握凉聋蚊敞那去硬卫挺唱佣甜君担如事连负步奔悔耀萄细压阴麦艘西量驶饰星闷逢若申凶胳壳轻错肚双症丈厚贺插忆被赏诉饼匙相王作迈烛恼趟草凑芦应礼帮货尊筛劲坐灾灵渠卵浴贫泽亏票烟惯河秘闭欺巴暂志泊神荣文才油根忠傻蹲排传愈豪培啊叛潮怀竖译腥秒纽浙狱晋痰页向丘棵钱踪贷慨铲委铃袖斗晒售咱挨描糊炎厨稀朱置端寻周罢李什静团喜秤雷病吧猫恰堆绪示取好鸡腔张哈宝多己伏渗轰驼浆昌兆赞汇共婚笛涨对驱盘跳判还窄歇咽红凝副德但季浪番碑钉盲永丸击福旁患馋撕仗路俘嘱恋久买刷内宏完吹前舒性吩狡稍冈肩逼松或牢街般菌馅温碰拌滑试折恩院精推惩遇评暗欠这黄左榆义罪害侄漠铅睬样贿驰泳砖孙活祖枝傲归它丹赴本娘衬桨瓶在缴壶蓝翁反参汗蓬虑拳奖克汤么叹目习锋羡汽纵昨却寄蜡起桑奇懒涉套慈缝彼建挽爆凤骡忽仔储蚁消捎专妈圣荒酷此雕畏乓棋色蝴尾羊膜侦芹嚷晃饲朋砌锻膊竹雄岁忧").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
    }
    @Test
    public void IT_TD_009_006_008_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","1").param("venueName","venue").param("address","冻奸吞宇算不鹿龄嚷柔蓝执崖弱红赢危毯蔑塔爸桑壮毛背糕婚悟绞摄舌去嫂睬缩赚炒寨旱约狼扑夕戏右槐钢域桐很躁乱京衔态洞呼住龙随宰陕忧缝劈筐鼓笔秆音醋箩降踩雀类增宴胃蜜宵混智聪全厅字绢割沟茧咬沃稻院矩替巧云没着昂典光驾剖还膀治欠础熊桌研芽讨拖球植呆霸歼调魄鸭胖壳剥某疲抬跨深松嘉解怕吊造界届罚型助豆探未那萌庭充期袄扒苗像傍秀轮辱暖惯害释崭糟竭号持穷坟膏懂什衡孕瓦制丁攻仪记亲涨狸鞋贝芝慢尼莲基区整慧称牧铜杠庸永削遵夜善风搁钳棉眨武抗阻宫肤绝决趋疗纹僚圣酒归登份应恭够保拐使恩酿喂艰连次哑稠报由特捉芳蚕菠坚配职负苍店赶敢")
                        .param("description","蠢初属基咐汉淹后者两穴窃救军蜓拴把造绘崖进济效治整貌危女质挠愁晓哭律闯每垦桥往送欣岔呈启厅第巾赖想哑舍沸材扁老寨换梦脏分督核拥歼匪状宁镰达衔办杀毕毁井器修鲜扎照络势派弃埋筐隶群壮坏拣锡风柳垂划满泼沉授源仿遣尼购重企毛存控帘抓跨平为因命八固玉适元没肃侍殖迅庆们追波燥烈掩逐谜嗓陈影甩傅枣扯惹转泥龟钩洽详眯欧悲扒视哗乞瞒胜库阶茎板教你采读熄盛干绍劫犁楚韵卷短醒选赛警呜梯带地蛇小糖一袄谷燃债装醉粮裁谅语愚屑讯销绢械种否花机蓄津睁眨竭虽差俱誉年软颗哥个辛煮罗秩敲骄争城孝表响肯泉雁吓果膛纠道奴度名就裂截辨注衰饮围锅索昏蕉唯戒点剂亡莲育失巧幕渐鞋承雾陆车麻幸绩高宿务代诊孔摊圆椅夕僻嗽湾驾尿气让窗稳宵告始段耍唇摸俊妹标吞阁厂辆膀赠痛炼阻降赵舟橘斯糠支宗浑恭题佩书卡轮婶背漫半犯冬雀敬冶父等桐维喉崭矩领穿赢狂哲例竞誓斧扶忘粥悠拖友总缓殃丝受累方哀拍森域香护兼墓顷窝顿右摄胶子邮阿盗垫芽脉枯讽隐慕织吴尽斩纺皮忍船蒙菠劣秋锈稼藏查扑浇嘉塞品最组单故杯土几辣膏鹰芒辜序烫校寺庭自帝沟筒敌逝朴协客骨喷广托岩三夜狸露慰诚愿填挖纪出外少遭腹田龄珠链操裤奥室徒恳纸巡掘看破混率祸窑潜垒认穷吼拒宽儿呆吨舅弱乖倦佛档怕急睡脸亦师州拐豆柿暴估略咏漂断除弹无垄蜜类即翼余违演僚绳氏忙积俯览则二蛛乐服梁金泛坊梳趴峡贞以串扬十旺象仅颂致从锤剪锣定覆万冰滨屈据纹歉勇辰按递捞翠渔罩帖丽横快弟枕巷乡葱望溪包袭币悟挂晕堵撑洪江士颠赔竿捏膝晨竟臭酱袜远堡长孕声工孩刀世撒絮鸣感跪较予锐占役脊议愧循罚纱力霸熔姑兵沈倘址萝投续魄良昼握凉聋蚊敞那去硬卫挺唱佣甜君担如事连负步奔悔耀萄细压阴麦艘西量驶饰星闷逢若申凶胳壳轻错肚双症丈厚贺插忆被赏诉饼匙相王作迈烛恼趟草凑芦应礼帮货尊筛劲坐灾灵渠卵浴贫泽亏票烟惯河秘闭欺巴暂志泊神荣文才油根忠傻蹲排传愈豪培啊叛潮怀竖译腥秒纽浙狱晋痰页向丘棵钱踪贷慨铲委铃袖斗晒售咱挨描糊炎厨稀朱置端寻周罢李什静团喜秤雷病吧猫恰堆绪示取好鸡腔张哈宝多己伏渗轰驼浆昌兆赞汇共婚笛涨对驱盘跳判还窄歇咽红凝副德但季浪番碑钉盲永丸击福旁患馋撕仗路俘嘱恋久买刷内宏完吹前舒性吩狡稍冈肩逼松或牢街般菌馅温碰拌滑试折恩院精推惩遇评暗欠这黄左榆义罪害侄漠铅睬样贿驰泳砖孙活祖枝傲归它丹赴本娘衬桨瓶在缴壶蓝翁反参汗蓬虑拳奖克汤么叹目习锋羡汽纵昨却寄蜡起桑奇懒涉套慈缝彼建挽爆凤骡忽仔储蚁消捎专妈圣荒酷此雕畏乓棋色蝴尾羊膜侦芹嚷晃饲朋砌锻膊竹雄岁").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");
        //ResultActions perform=mockMvc.perform(builder);
        assertThrows(NestedServletException.class,()->mockMvc.perform(builder),"venueID不存在!");
        // perform.andExpect(redirectedUrl("venue_manage"));
    }
    @Test
    public void IT_TD_009_006_009_001() throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","29").param("venueName","venue").param("address","冻奸吞宇算不鹿龄嚷柔蓝执崖弱红赢危毯蔑塔爸桑壮毛背糕婚悟绞摄舌去嫂睬缩赚炒寨旱约狼扑夕戏右槐钢域桐很躁乱京衔态洞呼住龙随宰陕忧缝劈筐鼓笔秆音醋箩降踩雀类增宴胃蜜宵混智聪全厅字绢割沟茧咬沃稻院矩替巧云没着昂典光驾剖还膀治欠础熊桌研芽讨拖球植呆霸歼调魄鸭胖壳剥某疲抬跨深松嘉解怕吊造界届罚型助豆探未那萌庭充期袄扒苗像傍秀轮辱暖惯害释崭糟竭号持穷坟膏懂什衡孕瓦制丁攻仪记亲涨狸鞋贝芝慢尼莲基区整慧称牧铜杠庸永削遵夜善风搁钳棉眨武抗阻宫肤绝决趋疗纹僚圣酒归登份应恭够保拐使恩酿喂艰连次哑稠报由特捉芳蚕菠坚配职负苍店赶敢")
                        .param("description","蠢初属基咐汉淹后者两穴窃救军蜓拴把造绘崖进济效治整貌危女质挠愁晓哭律闯每垦桥往送欣岔呈启厅第巾赖想哑舍沸材扁老寨换梦脏分督核拥歼匪状宁镰达衔办杀毕毁井器修鲜扎照络势派弃埋筐隶群壮坏拣锡风柳垂划满泼沉授源仿遣尼购重企毛存控帘抓跨平为因命八固玉适元没肃侍殖迅庆们追波燥烈掩逐谜嗓陈影甩傅枣扯惹转泥龟钩洽详眯欧悲扒视哗乞瞒胜库阶茎板教你采读熄盛干绍劫犁楚韵卷短醒选赛警呜梯带地蛇小糖一袄谷燃债装醉粮裁谅语愚屑讯销绢械种否花机蓄津睁眨竭虽差俱誉年软颗哥个辛煮罗秩敲骄争城孝表响肯泉雁吓果膛纠道奴度名就裂截辨注衰饮围锅索昏蕉唯戒点剂亡莲育失巧幕渐鞋承雾陆车麻幸绩高宿务代诊孔摊圆椅夕僻嗽湾驾尿气让窗稳宵告始段耍唇摸俊妹标吞阁厂辆膀赠痛炼阻降赵舟橘斯糠支宗浑恭题佩书卡轮婶背漫半犯冬雀敬冶父等桐维喉崭矩领穿赢狂哲例竞誓斧扶忘粥悠拖友总缓殃丝受累方哀拍森域香护兼墓顷窝顿右摄胶子邮阿盗垫芽脉枯讽隐慕织吴尽斩纺皮忍船蒙菠劣秋锈稼藏查扑浇嘉塞品最组单故杯土几辣膏鹰芒辜序烫校寺庭自帝沟筒敌逝朴协客骨喷广托岩三夜狸露慰诚愿填挖纪出外少遭腹田龄珠链操裤奥室徒恳纸巡掘看破混率祸窑潜垒认穷吼拒宽儿呆吨舅弱乖倦佛档怕急睡脸亦师州拐豆柿暴估略咏漂断除弹无垄蜜类即翼余违演僚绳氏忙积俯览则二蛛乐服梁金泛坊梳趴峡贞以串扬十旺象仅颂致从锤剪锣定覆万冰滨屈据纹歉勇辰按递捞翠渔罩帖丽横快弟枕巷乡葱望溪包袭币悟挂晕堵撑洪江士颠赔竿捏膝晨竟臭酱袜远堡长孕声工孩刀世撒絮鸣感跪较予锐占役脊议愧循罚纱力霸熔姑兵沈倘址萝投续魄良昼握凉聋蚊敞那去硬卫挺唱佣甜君担如事连负步奔悔耀萄细压阴麦艘西量驶饰星闷逢若申凶胳壳轻错肚双症丈厚贺插忆被赏诉饼匙相王作迈烛恼趟草凑芦应礼帮货尊筛劲坐灾灵渠卵浴贫泽亏票烟惯河秘闭欺巴暂志泊神荣文才油根忠傻蹲排传愈豪培啊叛潮怀竖译腥秒纽浙狱晋痰页向丘棵钱踪贷慨铲委铃袖斗晒售咱挨描糊炎厨稀朱置端寻周罢李什静团喜秤雷病吧猫恰堆绪示取好鸡腔张哈宝多己伏渗轰驼浆昌兆赞汇共婚笛涨对驱盘跳判还窄歇咽红凝副德但季浪番碑钉盲永丸击福旁患馋撕仗路俘嘱恋久买刷内宏完吹前舒性吩狡稍冈肩逼松或牢街般菌馅温碰拌滑试折恩院精推惩遇评暗欠这黄左榆义罪害侄漠铅睬样贿驰泳砖孙活祖枝傲归它丹赴本娘衬桨瓶在缴壶蓝翁反参汗蓬虑拳奖克汤么叹目习锋羡汽纵昨却寄蜡起桑奇懒涉套慈缝彼建挽爆凤骡忽仔储蚁消捎专妈圣荒酷此雕畏乓棋色蝴尾羊膜侦芹嚷晃饲朋砌锻膊竹雄岁").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");
        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
    }
    @Test
    public void return_venue_manage_html() throws Exception {
        ResultActions perform=mockMvc.perform(get("/venue_manage"));
        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"total");
    }

    @Test
    public void return_edit_venue() throws Exception {
        ResultActions perform=mockMvc.perform(get("/venue_edit").param("venueID","2"));
        MvcResult mvcResult=perform.andReturn();
        ModelAndView mv=mvcResult.getModelAndView();
        perform.andExpect(status().isOk());
        assertModelAttributeAvailable(mv,"venue");
    }

    @Test
    public void return_venue_add_html() throws Exception {
        ResultActions perform=mockMvc.perform(get("/venue_add"));
        perform.andExpect(status().isOk());
    }

    @Test
    public void return_venue_list()  throws Exception{

        ResultActions perform=mockMvc.perform(get("/venueList.do").param("page","1"));
        perform.andExpect(status().isOk());
    }

    @Test
    public void admin_add_venue_picture_is_null()  throws Exception{
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","this is address")
                        .param("description","this is description").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
    }

    @Test
    public void admin_add_venue_picture_is_not_null() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/addVenue.do")
                        .file(mockMultipartFile).param("venueName","venue").param("address","this is address")
                        .param("description","this is description").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
    }

    @Test
    public void admin_modify_venue_picture_is_null() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","",
                "picture", "".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","2").param("venueName","venue").param("address","this is address")
                        .param("description","this is description").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
    }

    @Test
    public void admin_modify_venue_picture_is_not_null() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("picture","1.bmp",
                "picture", "1.bmp".getBytes());
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/modifyVenue.do")
                        .file(mockMultipartFile).param("venueID","2").param("venueName","venue").param("address","this is address")
                        .param("description","this is description").param("price","100")
                        .param("open_time","08:00").param("close_time","18:00");

        ResultActions perform=mockMvc.perform(builder);
        perform.andExpect(redirectedUrl("venue_manage"));
    }

    @Test
    public void admin_del_venue() throws Exception {
        ResultActions perform=mockMvc.perform(post("/delVenue.do").param("venueID","2"));
        perform.andExpect(status().isOk());
    }

    @Test
    public  void return_already_exist_same_venue_name()  throws Exception{
        ResultActions perform=mockMvc.perform(post("/checkVenueName.do").param("venueName","222"));
        perform.andExpect(status().isOk()).andExpect(content().string("false"));
    }

    @Test
    public  void return_not_exist_same_venue_name()  throws Exception{
        ResultActions perform=mockMvc.perform(post("/checkVenueName.do").param("venueName","venue"));
        perform.andExpect(status().isOk()).andExpect(content().string("true"));

    }
}
