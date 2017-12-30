

/**
 * @Author zhang
 * @Date 2017/11/9 15:28
 * @Content 英雄类（他是一个父类）
 */
public class Hero {

    private String name;//英雄名字
    private int HP;//英雄血量
    private int attack;//英雄攻击力
    private int DefenseivePowerNumber;//英雄防御力



    // -------------我们课上讲的封装 start----------
    public int getAttack() { return attack; }

    public void setAttack(int attack) {
        this.attack = attack;
    }
    public String getName() {
        return name;
    }

    public void setName(String name){ this.name = name; }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDefenNum() {return DefenseivePowerNumber;}

    public void setDefenseivePowerNumber(int DefenseivePowerNumber){
        this.DefenseivePowerNumber = DefenseivePowerNumber;
    }

    //----------封装 end------------------------------


   //获取武器
    public void getWeapon(Weapon weapon){
        //先获取自己当前的攻击力
        int selfAttack = getAttack();
        //讲准备提升的攻击力加到当前自己攻击力上
        if (selfAttack <= 2000){
            selfAttack += weapon.getWeaponAttact();
            setAttack(selfAttack);

        }
        //把提升攻击力的这个过程打印出来
        System.out.println(this.getName() + "获得了" + weapon.getWeaponName() + "，攻击力提升了" + weapon.getWeaponAttact() + "此时攻击力为" + this.getAttack());
    }
    //获取防御装备并显示现在的防御力
    public void getDefenseivePowerNumber(Defenders defenders){

        int selfDefenseivePowerNumber = getDefenNum();

        selfDefenseivePowerNumber += defenders.getDefenseivePower();
        setDefenseivePowerNumber(selfDefenseivePowerNumber);

        System.out.println(this.getName() + "获得了" + defenders.getDefendersName() + ",防御力提升了" + defenders.getDefenseivePower());
        System.out.println(this.getName() + "此时的防御力为" + this.getDefenNum());


    }

}

