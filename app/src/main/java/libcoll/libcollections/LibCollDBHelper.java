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

        Toast.makeText(cont, "数据库创建成功！",
            Toast.LENGTH_SHORT).show();

        // 样例数据
        db.execSQL("INSERT INTO category(name) VALUES('科普')");
        db.execSQL("INSERT INTO category(name) VALUES('计算机')");
        db.execSQL("INSERT INTO category(name) VALUES('互联网')");
        db.execSQL("INSERT INTO category(name) VALUES('爱情')");
        db.execSQL("INSERT INTO category(name) VALUES('旅行')");
        db.execSQL("INSERT INTO category(name) VALUES('生活')");
        db.execSQL("INSERT INTO category(name) VALUES('哲学')");

        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121155352','C++ Primer 中文版（第 5 版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111213826','Java编程思想 （第4版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115145543','C++ Primer 中文版（第 4 版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111421900','深入理解Java虚拟机（第2版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787100013239','哥德尔、艾舍尔、巴赫','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111255833','Effective java 中文版（第2版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787560926995','STL源码剖析','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111135104','计算机程序的构造和解释','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111370048','Java并发编程实战','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508647357','人类简史','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787513300711','失控','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787213052545','大数据时代','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787560924182','深度探索C++对象模型','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121139512','浪潮之巅','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787560925257','Effective C++中文版','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508649719','从0到1','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115282828','数学之美','TP301.6 165','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115249494','黑客与画家','TP3-53 15','自然科学图书区（北楼）1架B面5列6层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787535732309','时间简史','P159 21','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111349662','深入理解Java虚拟机','TP312JA 1469','自然科学图书区（北楼）6架B面1列5层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787538276374','上帝掷骰子吗','O413-09 1','自然科学图书区（南楼）13架B面1列2层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787030107596','从一到无穷大','N49 33','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121106101','编码','TN911.2 9','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111239505','JAVA核心技术（卷1）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111102021','C++程序设计语言（特别版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9780321334879','Effective C++','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9780131872486','Thinking in Java','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787560927824','C++标准程序库','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111090984','C++语言的设计和演化','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508309897','C++ Primer中文版','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121192821','Linux多线程服务端编程','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115134165','C++Primer Plus','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121109416','分布式Java应用','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787542654434','极简宇宙史','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121022982','代码大全（第2版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111321330','深入理解计算机系统（原书第2版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787206030048','自私的基因','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787542629456','当彩色的声音尝起来是甜的','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9781849687881','Java 7 Concurrency Cookbook','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9780137142521','Java Performance','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508634159','自私的基因','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111080787','编码的奥秘','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806639641','冷浪漫','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111128069','C程序设计语言','TP312C 290','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806797549','万物简史','N49 164','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787542848048','超越时空','O412.1 44','（南校区）自然科学综合书库11架B面2列5层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508672069','未来简史','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111187776','算法导论（原书第2版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508638119','众病之王','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787560929064','C++设计新思维','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121043161','JAVA并发编程实践','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115209429','Spring揭秘','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787513304610','谣言粉碎机','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508344980','Head First Java（第二版·中文版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121016844','expert one-on-one J2EE Development without EJB 中文版','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508321752','深入理解计算机系统','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111321545','Maven实战','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787549501076','你一定爱读的极简欧洲史','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787535733597','果壳中的宇宙','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115216878','代码整洁之道','TP311.53 M382','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115226266','鸟哥的Linux私房菜','TP316.89 60-2/V.1','自然科学图书区（北楼）8架A面2列8层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115179289','编程珠玑','TP311.1 B477/E.2','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121227615','大型网站系统与Java中间件开发实践','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111108078','C++编程思想（第1卷）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787560925110','Essential C++中文版','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115342973','Java性能优化权威指南','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111358404','黑客','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111104414','Java编程思想(第2版)','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121060748','编程之美','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787100085007','发现之旅','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111445142','Java核心技术·卷1：基础知识（原书第9版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9780321349606','Java Concurrency in Practice','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121085116','程序员的自我修养','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111340812','Java语言程序设计','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121123320','Effective C++','TP312C 577','（南校区）工业技术专业书库6架B面1列4层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787309044546','什么是数学','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111303220','C++程序设计原理与实践','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115171788','C++沉思录','TP312C++ 337','自然科学图书区（北楼）4架B面7列7层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115142054','C++编程规范','TP312C++ 763','（南校区）工业技术专业书库6架B面15列2层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115106223','C++沉思录','TP312C++ 337','自然科学图书区（北楼）4架B面7列7层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787302059325','人月神话','TP311.52 90','自然科学图书区（北楼）3架A面4列5层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787506261579','简爱（英文全本）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787532731077','不能承受的生命之轻','I514.4 19','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787544270878','解忧杂货店','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787544253994','百年孤独','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787020024759','围城','I246.5 120-2','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787208061644','追风筝的人','I712.45 181','（南校区）文学、艺术、历史书库12架B面12列2层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787544210966','活着','I247.5 3573','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787532725694','挪威的森林','I313.4 237','（南校区）文学、艺术、历史书库10架B面10列2层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121070174','About Face 3 交互设计精髓','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115243249','简约至上','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111223108','用户体验的要素','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111184829','点石成金','TP393.092 1256','（南校区）工业技术专业书库14架B面2列2层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115352118','UNIX环境高级编程（第3版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115261960','计算机科学概论（第11版）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115147318','UNIX环境高级编程','TP316.81 216-2','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787111298854','C++程序设计语言','TP312C++ 2','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787801146274','英语魔法师之语法俱乐部','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121129018','Python灰帽子','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787515303505','考拉小巫的英语学习日记','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787560521541','17天搞定GRE单词','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787119083292','把你的英语用起来！','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115275868','思考的乐趣','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787107165122','中国古代史 全一册','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787514840742','陪孩子读古诗词·日月星露','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787107164866','全日制普通高级中学教科书（必修）数学第二册（下A）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787107185748','高中语文必修第五册','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787514840759','陪孩子读古诗词·虫鱼鸟兽','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787107171062','全日制普通高级中学教科书（必修）数学第一册（下）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787514800333','老鼠嫁女','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787514837193','十面埋伏','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787505414709','何以笙箫默','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508622828','背包十年','','社会科学图书区（南楼）21架B面3列3层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787536023918','倾城之恋','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806570920','飘','I712.4 112-5/V.1','（南校区）文学、艺术、历史书库12架B面5列2层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787530211113','撒哈拉的故事','I267 2252','社会科学图书区（南楼）20架B面4列4层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787532752805','寻路中国','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787532750160','不去会死！','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787539971810','岛上书店','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508616339','迟到的间隔年','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787540468798','乖，摸摸头','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787806638866','拆掉思维里的墙','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787800733666','谁动了我的奶酪？','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787539982830','无声告白','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787507419887','秘密','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787807023777','少有人走的路','B821-49 513/V.3','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787561339121','杜拉拉升职记','I247.57 2367','社会科学图书区（南楼）19架B面4列2层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508632018','我就是想停下来，看看这个世界','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787506365437','活着','K825.6 437','非自助借还(RFID)图书，无法定位!')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787505722460','明朝那些事儿（壹）','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787307075429','天才在左 疯子在右','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787801093660','乌合之众','C912.64 3-3','（南校区）社会科学综合书库8架B面5列5层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115111302','心理学与生活','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787108009821','万历十五年','K248.53 2-2','社会科学图书区（南楼）32架A面4列6层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787108015280','中国历代政治得失','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787108041531','邓小平时代','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787020042494','小王子','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508616780','世界因你不同','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787549529322','看见','I339.65 2','（南校区）文学、艺术、历史书库11架A面4列2层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508630069','史蒂夫·乔布斯传','K837.125.38=6 3','社会科学图书区（南楼）41架A面3列6层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787506309745','苏菲的世界','I533.4 8','社会科学图书区（南楼）22架B面1列1层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787506341271','苏菲的世界','I533.4 8','社会科学图书区（南楼）22架B面1列1层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787121105777','人人都是产品经理','F273.2 562','（南校区）法律、经济专业书库33架B面4列2层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787507532807','Facebook效应','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787308164207','腾讯传','非图书馆藏书','暂无该书位置信息')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787115224170','结网','TP393.092 2689','（南校区）工业技术专业书库15架A面1列5层')");
        db.execSQL("INSERT INTO book(isbn, title, callno, location) VALUES('9787508607245','长尾理论','F274 548','非自助借还(RFID)图书，无法定位!')");

        Toast.makeText(cont, "为便于演示，已将样例数据加载进数据库",
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
