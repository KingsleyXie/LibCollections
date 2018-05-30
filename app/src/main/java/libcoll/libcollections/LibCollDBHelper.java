package libcoll.libcollections;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class LibCollDBHelper extends SQLiteOpenHelper {
    private static final String CREATE_BOOK =
    "CREATE TABLE IF NOT EXISTS book (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "isbn TEXT UNIQUE NOT NULL," +
        "title TEXT NOT NULL," +
        "callno TEXT NOT NULL," +
        "location TEXT NOT NULL," +
        "remark TEXT DEFAULT NULL" +
    ")";

    private static final String CREATE_CATEGORY =
    "CREATE TABLE IF NOT EXISTS category (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "name TEXT UNIQUE NOT NULL" +
    ")";

    private static final String CREATE_BOOK_CATEGORY =
    "CREATE TABLE IF NOT EXISTS book_category (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "book_id INTEGER NOT NULL," +
        "category_id INTEGER NOT NULL," +
        "FOREIGN KEY (book_id) REFERENCES book(id)," +
        "FOREIGN KEY (category_id) REFERENCES category(id)" +
    ")";

    private Context cont;

    public LibCollDBHelper(Context context, String name,
                           SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        cont = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        db.execSQL(CREATE_BOOK_CATEGORY);

        db.execSQL("INSERT INTO category(name) VALUES('互联网')");
        db.execSQL("INSERT INTO category(name) VALUES('数据库')");
        db.execSQL("INSERT INTO category(name) VALUES('设计模式')");
        db.execSQL("INSERT INTO category(name) VALUES('计算机')");
        db.execSQL("INSERT INTO category(name) VALUES('科普')");
        db.execSQL("INSERT INTO category(name) VALUES('随笔')");
        db.execSQL("INSERT INTO category(name) VALUES('散文')");
        db.execSQL("INSERT INTO category(name) VALUES('爱情')");
        db.execSQL("INSERT INTO category(name) VALUES('哲学')");

        Toast.makeText(cont, "已成功初始化数据库",
            Toast.LENGTH_SHORT).show();

        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508353937','Head First 设计模式（中文版）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508649719','从0到1','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508647357','人类简史','K02-49 1','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115191120','MySQL必知必会','TP311.138SQ 392','（南校区）工业技术专业书库5架A面11列4层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115249494','黑客与画家','TP3-53 15','自然科学图书区（北楼）1架B面5列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787213052545','大数据时代','F062.5-49 1','（南校区）法律、经济专业书库23架A面4列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787535732309','时间简史','P159 21','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787538276374','上帝掷骰子吗','O413-09 1','自然科学图书区（南楼）13架B面1列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115282828','数学之美','TP301.6 165','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111075752','设计模式','TP311.11 37','（南校区）工业技术专业书库4架B面6列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121106101','编码','TN911.2 9','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121139512','浪潮之巅','F49 119','社会科学图书区（北楼）27架B面4列9层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787302162063','大话设计模式','TP311.5 349','（南校区）工业技术专业书库5架B面1列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111196877','数据库系统概念','TP311.13 150','自然科学图书区（北楼）2架A面4列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787302071976','敏捷软件开发','TP311.52 147','（南校区）工业技术专业书库5架B面5列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121102455','高性能MySQL（第二版）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111302872','数据库系统实现','TP311.13 149','自然科学图书区（北楼）2架A面4列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787542631664','送你一颗子弹','I267.1 1004','（南校区）文学、艺术、历史书库10架A面5列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787544717731','这些人，那些事','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787540458027','从你的全世界路过','I247.7 1615','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121198854','高性能MySQL','TP311.138SQ 450','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787100013239','哥德尔、艾舍尔、巴赫','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787108032911','目送','I267 2285','（南校区）文学、艺术、历史书库9架B面4列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111135104','计算机程序的构造和解释','TP311.1 42','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787564101657','深入浅出设计模式（影印版）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787513300711','失控','G303-49 5','（南校区）社会科学综合书库13架B面15列4层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787549529322','看见','I339.65 2','（南校区）文学、艺术、历史书库11架A面4列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787030107596','从一到无穷大','N49 33','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9789573305545','撒哈拉的故事','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806276983','文化苦旅','I267 1078','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787108018809','我们仨','K825.6 189','（南校区）文学、艺术、历史书库17架B面7列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787506261579','简爱（英文全本）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787536023918','倾城之恋','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787505414709','何以笙箫默','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787532725694','挪威的森林','I313.4 237','（南校区）文学、艺术、历史书库10架B面10列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806570920','飘','I712.4 112-5/V.1','（南校区）文学、艺术、历史书库12架B面5列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787506309745','苏菲的世界','I533.4 8','社会科学图书区（南楼）22架B面1列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787506341271','苏菲的世界','I533.4 8','社会科学图书区（南楼）22架B面1列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787020042494','小王子','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787307075429','天才在左 疯子在右','I25 1461','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787532731077','不能承受的生命之轻','I514.4 19','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787300148120','认知盈余','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508607245','长尾理论','F274 548','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787507532807','Facebook(isbn, title, callno, location)效应','F279.712.444 13','社会科学图书区（北楼）26架B面1列7层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508630069','史蒂夫·乔布斯传','K837.125.38=6 3','社会科学图书区（南楼）41架A面3列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121105777','人人都是产品经理','F273.2 562','（南校区）法律、经济专业书库33架B面4列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115224170','结网','TP393.092 2689','（南校区）工业技术专业书库15架A面1列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508645131','参与感','F426.63 28','（南校区）法律、经济专业书库37架A面4列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787308164207','腾讯传','F279.244.4 134','（南校区）法律、经济专业书库35架B面4列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787300105390','未来是湿的','TP393.4 498','（南校区）工业技术专业书库15架B面2列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787560970189','启示录','F49 134','（南校区）法律、经济专业书库37架A面13列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508624488','浅薄','B80-05 1','社会科学图书区（北楼）3架A面6列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121274534','必然','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508646640','创业维艰','F279.712.3 64','（南校区）法律、经济专业书库35架B面12列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508616384','免费','F713.3 557','（南校区）法律、经济专业书库38架B面9列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787302089773','计算机网络','TP309 1-2','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787040195835','数据库系统概论（第四版）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115251121','MongoDB权威指南','TP311.13 551','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115313980','SQL必知必会','TP311.138SQ 297','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115261274','SQL反模式','TP311.138SQ 509','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115162601','SQL必知必会（第3版）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111321880','MySQL技术内幕','TP311.138SQ 489','（南校区）工业技术专业书库5架A面12列4层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111375296','数据库系统概念','TP311.13 150','自然科学图书区（北楼）2架A面4列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111464747','Redis设计与实现','TP311.138RE 1','（南校区）工业技术专业书库5架A面8列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115150325','Oracle 9i & 10g编程艺术','TP311.138OR 68','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121058349','SQL语言艺术','TP311.138SQ 362','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121260544','数据库索引设计与优化','TP311.13 704','（南校区）工业技术专业书库4架B面12列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115312242','七周七数据库','TP311.13 629','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111433033','NoSQL精粹','TP311.138SQ 560','（南校区）工业技术专业书库5架A面12列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121087400','MySQL性能调优与架构设计','TP311.138SQ 411','（南校区）工业技术专业书库5架A面11列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121116933','深入浅出数据分析','O212.1 46','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115260161','未公开的Oracle数据库秘密','TP311.138OR 323','自然科学图书区（北楼）2架B面3列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9780596007126','Head First Design Patterns','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111295440','设计模式之禅','TP312 428','（南校区）工业技术专业书库6架A面2列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115191281','JavaScript设计模式','TP312JA 1151','（南校区）工业技术专业书库7架B面14列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787505380004','Java与模式','TP312JA 258','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115150950','设计模式解析','TP311.5 266','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111211266','设计模式','TP311.11 37','（南校区）工业技术专业书库4架B面6列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115388889','JavaScript设计模式与开发实践','TP312JA 2093','（南校区）工业技术专业书库8架A面5列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115153364','重构与模式','TP311.1 78','（南校区）工业技术专业书库4架B面5列4层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111143055','企业应用架构模式','F270.7 234','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787800116278','建筑的永恒之道','TU-80 22','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9780201633610','Design patterns','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111186823','UML和模式应用','TP312UM 4','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111095071','设计模式','TP311.11 37','（南校区）工业技术专业书库4架B面6列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111187776','算法导论（原书第2版）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115145543','C++ Primer 中文版（第 4 版）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121022982','代码大全（第2版）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111321330','深入理解计算机系统（原书第2版）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111080787','编码的奥秘','TP301 26','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121085116','程序员的自我修养','TP311.1 209','（南校区）工业技术专业书库4架B面6列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111128069','C程序设计语言','TP312C 290','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111358404','黑客','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508321752','深入理解计算机系统','TP3 536','（南校区）工业技术专业书库4架A面2列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121060748','编程之美','TP311.1 97','（南校区）工业技术专业书库4架B面5列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115179289','编程珠玑','TP311.1 B477/E.2','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787302059325','人月神话','TP311.52 90','自然科学图书区（北楼）3架A面4列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787542654434','极简宇宙史','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787542848048','超越时空','O412.1 44','（南校区）自然科学综合书库11架B面2列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806639641','冷浪漫','N49 270','自然科学图书区（南楼）1架B面3列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787206030048','自私的基因','Q953 1-2','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806797549','万物简史','N49 164','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508634159','自私的基因','Q953 1-3','（南校区）医学专业书库2架B面3列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508672069','未来简史','K02-49 3','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787549501076','你一定爱读的极简欧洲史','K500.9 5','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787100085007','发现之旅','Z228 241','（南校区）社会科学综合书库22架B面6列4层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508638119','众病之王','R730.231 9','（南校区）医学专业书库12架B面1列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787542629456','当彩色的声音尝起来是甜的','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787535733597','果壳中的宇宙','P159 15','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787513304610','谣言粉碎机','Z228 246','（南校区）社会科学综合书库22架B面6列4层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787309044546','什么是数学','O1-49 39','（南校区）自然科学综合书库2架A面2列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787535767134','复杂','O572 4','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787544242820','当我谈跑步时我谈些什么','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787542629586','民主的细节','D771.2 87','（南校区）法律、经济专业书库7架B面8列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787563383870','我执','I267 2270','（南校区）文学、艺术、历史书库9架B面6列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787563391271','孤独六讲','I267 3649','（南校区）文学、艺术、历史书库9架B面7列4层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787020068616','亲爱的安德烈','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787563379637','常识','I267.1 916','（南校区）文学、艺术、历史书库10架A面8列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787300152202','你永远都无法叫醒一个装睡的人','I267.1 1278','（南校区）文学、艺术、历史书库10架A面10列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508630649','像我这样笨拙地生活','I267.1 1403','（南校区）文学、艺术、历史书库10架A面11列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787500627098','沉默的大多数','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787506341011','素年锦时','I267 2591','社会科学图书区（南楼）20架B面4列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787308108584','观念的水位','I267.1 1378','（南校区）文学、艺术、历史书库10架A面8列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787563351398','退步集','J052-53 2','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806459065','用我一辈子去忘记','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787513303279','爸爸爱喜禾','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787020069903','灵魂只能独行','','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787544236973','空谷幽兰','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787108033635','孩子你慢慢来','I267 2681','（南校区）文学、艺术、历史书库9架B面6列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806398791','撒哈拉的故事','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787108035295','城门开','I267.1 1090','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787532739578','瓦尔登湖','I712.6 1','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787201088945','皮囊','I267 4471','（南校区）文学、艺术、历史书库9架B面11列4层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787222065413','我的阿勒泰','I267 3924','（南校区）文学、艺术、历史书库9架B面9列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787801423849','行者无疆','I267 1041','（南校区）文学、艺术、历史书库9架A面6列4层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787506318891','千年一叹','I267.4 10','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806399071','哭泣的骆驼','I267 969','社会科学图书区（南楼）20架B面3列6层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787535435590','不朽','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787530208922','梦里花落知多少','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787535467850','且以永日','I267 4070','（南校区）文学、艺术、历史书库9架B面10列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508618081','失恋33天','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787108017444','向左走·向右走','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787530201244','穆斯林的葬礼','I247.57 393','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787532741571','一个陌生女人的来信','I521.4 18-6','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787020040179','傲慢与偏见','I561.4 48-2','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787531325093','梦里花落知多少','I247.57 581','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787505416772','致我们终将逝去的青春','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787544258975','霍乱时期的爱情','I775.4 5-3','（南校区）文学、艺术、历史书库13架A面12列4层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787020060504','时间旅行者的妻子','I712.45 1382','（南校区）文学、艺术、历史书库13架A面7列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787532736874','情人','I565.4 323','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787201048161','情书','H319.4 1336','（南校区）社会科学综合书库19架B面7列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806859988','爱你就像爱生命','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787539926605','山楂树之恋','I247.57 2391','（南校区）文学、艺术、历史书库7架A面12列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787539932811','微微一笑很倾城','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787550013247','摆渡人','I561.45 596','（南校区）文学、艺术、历史书库11架B面16列3层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787305063749','最初的爱情 最后的仪式','I561.45 150','（南校区）文学、艺术、历史书库11架B面16列2层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787100004824','西方哲学史（上卷）','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787100017565','理想国','K545.2 1','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787108024558','存在与时间','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787801872166','中国哲学简史','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787308086141','维特根斯坦传','非图书馆藏书','暂无该书位置信息');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787208081178','人生的智慧','B516.41 12','（南校区）社会科学综合书库4架A面4列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787229040369','禅与摩托车维修艺术','','非自助借还(RFID)图书，无法定位!');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787563345236','大问题','B0 75','社会科学图书区（北楼）1架A面5列9层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787802115743','沉思录','B848.4-49 552','（南校区）社会科学综合书库6架B面1列5层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787538291445','哲学家们都干了些什么？','B5 142','（南校区）社会科学综合书库3架B面5列1层');");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787100011662','作为意志和表象的世界','B516.41 6','（南校区）社会科学综合书库4架A面4列1层');");

        Toast.makeText(cont, "为便于演示，已导入部分样例数据",
            Toast.LENGTH_LONG).show();
    }

    public void onUpgrade(SQLiteDatabase db,
        int oldVersion, int newVersion) {
        Toast.makeText(cont, "删库跑路中......",
                Toast.LENGTH_SHORT).show();

        db.execSQL("DROP TABLE IF EXISTS book");
        db.execSQL("DROP TABLE IF EXISTS category");
        db.execSQL("DROP TABLE IF EXISTS book_category");

        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {
        Toast.makeText(cont, "删库跑路中......",
            Toast.LENGTH_SHORT).show();

        db.execSQL("DROP TABLE IF EXISTS book");
        db.execSQL("DROP TABLE IF EXISTS category");
        db.execSQL("DROP TABLE IF EXISTS book_category");

        onCreate(db);
    }
}
