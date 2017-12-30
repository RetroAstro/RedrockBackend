import java.util.Random;

/**
 * @Author zhang
 * @Date 2017/11/9 15:51
 * @Content
 */
public class TIMO extends Hero{



    public void attack(Garen garen){
        int left = 0;
        int anotherHeroLeftHP = 0;
        //提莫拿自己的攻击力去攻击传入的garen
        if(getAttack() <= garen.getHP()){
            //如果提莫攻击力比盖伦的血量还低 说明这次攻击不足以击杀对方
            //我们就把盖伦的HP减去  减去的值应该是提莫当前的攻击力
            anotherHeroLeftHP = garen.getHP() + this.getDefenNum() - getAttack();
            //然后把被攻击的英雄还剩下的血量设置回去
            garen.setHP(anotherHeroLeftHP);
            left = getAttack() - this.getDefenNum();
            System.out.println(this.getName() + "攻击了" + garen.getName() + "," + "敌方调用了自己的防御属性，" +
            garen.getName() + "实际受到的伤害为" + left + "，还剩下HP" +garen.getHP() );
        }else{
            System.out.println(this.getName() +"对盖伦发出了最后一击！！！");
            // create random object
            Random randomno = new Random();

            // get next next boolean value
            boolean value = randomno.nextBoolean();
            if (value){
                System.out.println("不能让提莫轻易的把盖伦杀死了！^_^)");
                this.setHP(0);
                System.out.println("提莫不小心拿起武器攻击了自己....！？");
            }else {
                garen.setHP(0);
                System.out.println(this.getName() + "攻击了" + garen.getName() + "," + garen.getName() + "HP还剩0");
            }
        }
    }

    //提莫种蘑菇的方法
    public void chaofeng(){
        System.out.println("提莫嘲讽了对面的大傻子");
    }

    //获取获取技能
    public void getSkills(Skills skill,Hero enemy){

        int enemyHeroLeftHP = 0;

        System.out.println(this.getName() + "发出了" + skill.getSkillName() + "对" +enemy.getName()+"造成了" + skill.getSkillAttact() + "点伤害");
        if (skill.getSkillAttact() <= enemy.getHP()){

            enemyHeroLeftHP = enemy.getHP() + this.getDefenNum() - skill.getSkillAttact();
            enemy.setHP(enemyHeroLeftHP);
            System.out.println(enemy.getName() + "的HP还剩下" + enemy.getHP());
        }else {
            enemy.setHP(0);
            System.out.println(this.getName() + "的技能对" + enemy.getName() + "造成了致命伤害，" + "敌方阵亡！");
        }

    }

}
