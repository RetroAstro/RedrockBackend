
import java.util.Random;

/**
 * @Author zhang
 * @Date 2017/11/9 15:55
 * @Content 对战舞台类
 */
public class Stage {
    //盖伦的武器名字
    public String garenWeaponName[] = {"风暴之剑","冰锤","海克斯手枪","饮血剑"};
    //盖伦的武器攻击力
    public int garenWeaponAttack[] = {30,20,24,25};
    //盖伦的技能
    public String garenSkillName[] = {"致命打击","勇气","审判","德玛西亚正义"};
    //盖伦的技能攻击力
    public int garenSkillAttack[] = {25,0,20,50};
    //盖伦的防御装备
    public String garenDefendersName[] = {"兰顿之兆","日炎斗篷","狂徒铠甲","荆棘之甲"};
    //盖伦防御装备的防御力
    public int garenDefenseivePower[] = {2,3,4,5};
    //提莫的技能
    public String timoSkillName[] = {"小莫飞刀","小莫快跑","毒性射击","种蘑菇"};
    //提莫的技能攻击力
    public int timoSkillAttack[] = {30,15,35,60};
    //提莫的防御装备
    public String timoDefendersName[] = {"守护天使","振奋铠甲","冰霜之锤","冰腕护手"};
    //提莫防御装备的防御力
    public int timoDefenseivePower[] = {3,4,5,6};
    //提莫的武器名字
    public String timoWeaponName[] = {"电刀","饮血剑","破败王者","杀戮之剑"};
    //提莫的武器攻击力
    public int timoWeaponAttack[] = {32,30,22,24};


    public void startWar(Garen garen,TIMO timo) {

        System.out.println("---战斗开始----");

        while(true) {

            //如果有任何一个英雄血量<=0 游戏结束
            if(garen.getHP() <=0 || timo.getHP() <=0){
                if(garen.getHP() <=0){
                    System.out.println(timo.getName() + "战胜了" + garen.getName());
                }else{
                    System.out.println(garen.getName() + "战胜了" + timo.getName());
                }
                break;
            }

            //实例化武器类 并且赋值给一个叫 garenWeapon的引用
            //这是属于盖伦的武器
            Weapon garenWeapon = new Weapon();
            //java中的随机数类
            Random garenRandom = new Random(System.currentTimeMillis());
            //随机0-3的一个整数出来
            int garenNumber = garenRandom.nextInt(4);
            //给盖伦的武器设置名字和攻击力
            garenWeapon.setWeaponAttact(garenWeaponAttack[garenNumber]);
            garenWeapon.setWeaponName(garenWeaponName[garenNumber]);

            //实例化技能类 并赋值给一个叫 garenSkill的引用
            //这是属于盖伦的技能
            Skills garenSkill = new Skills();
            //给盖伦的技能设置名字和攻击力
            garenSkill.setSkillAttact(garenSkillAttack[garenNumber]);
            garenSkill.setSkillName(garenSkillName[garenNumber]);
            //实例化防御类 并赋值给一个叫 garenDefenders的引用
            //这是属于盖伦的防御装备
            Defenders garenDefenders = new Defenders();
            //给盖伦的防御装备设置名字和攻击力
            garenDefenders.setDefendersName(garenDefendersName[garenNumber]);
            garenDefenders.setDefenseivePower(garenDefenseivePower[garenNumber]);


            //实例化武器类 并且赋值给一个叫 timoWeapon的引用
            //这是属于提莫的武器
            Weapon timoWeapon = new Weapon();
            Random timoRandon = new Random(System.currentTimeMillis());
            int timoNumber = timoRandon.nextInt(4);
            timoWeapon.setWeaponName(timoWeaponName[timoNumber]);
            timoWeapon.setWeaponAttact(timoWeaponAttack[timoNumber]);

            //这是属于提莫的技能
            Skills timoSkill = new Skills();
            //给提莫的技能设置名字和攻击力
            timoSkill.setSkillAttact(timoSkillAttack[garenNumber]);
            timoSkill.setSkillName(timoSkillName[garenNumber]);

            //这是属于提莫的防御装备
            Defenders timoDefenders = new Defenders();
            //给提莫的防御装备设置名字和攻击力
            timoDefenders.setDefendersName(timoDefendersName[timoNumber]);
            timoDefenders.setDefenseivePower(timoDefenseivePower[timoNumber]);


            //盖伦有五种状态 获取武器 攻击提莫  技能攻击 获取防御装备 什么也不做
            Random garenAction = new Random(System.currentTimeMillis());
            int num1 = garenAction.nextInt(4) + 1;
            switch(num1){
                case 1 :
                    garen.attack(timo);
                    break;
                case 2 :
                    garen.getWeapon(garenWeapon);
                    break;
                case 3 :
                    garen.getSkills(garenSkill,timo);
                case 4 :
                    garen.getDefenseivePowerNumber(garenDefenders);
                default :
                    System.out.println(garen.getName() + "什么也没做");
                    break;
            }
            //如果有任何一个英雄血量<=0 游戏结束
            if(garen.getHP() <=0 || timo.getHP() <=0){
                if(garen.getHP() <=0){
                    System.out.println(timo.getName() + "战胜了" + garen.getName());
                }else{
                    System.out.println(garen.getName() + "战胜了" + timo.getName());
                }
                break;
            }

            //提莫有六种状态 获取武器 攻击盖伦 嘲讽盖伦  技能攻击 获取防御装备 什么也不做
            Random timoAction = new Random(System.currentTimeMillis());
            int num2 = timoAction.nextInt(5) + 1;
            switch(num2){
                case 1 :
                    timo.getSkills(timoSkill,garen);
                    break;
                case 2 :
                    timo.getDefenseivePowerNumber(timoDefenders);
                    break;
                case 3 :
                    timo.attack(garen);
                    break;
                case 4 :
                    timo.chaofeng();
                    break;
                case 5 :
                    timo.getWeapon(timoWeapon);
                default :
                    System.out.println(timo.getName() + "什么也没有做");
                    break;
            }

        }

    }

    public static void main(String[] args) {
        //实例化一个盖伦
        Garen garen = new Garen();
        garen.setName("gay伦");
        garen.setAttack(4);
        garen.setHP(10000);
        //实例化一个提莫
        TIMO timo = new TIMO();
        timo.setName("提莫");
        timo.setHP(3000);
        timo.setAttack(8);
        //实例化一个对战舞台 调用打架方法
        Stage stage = new Stage();
        stage.startWar(garen,timo);
    }
}
