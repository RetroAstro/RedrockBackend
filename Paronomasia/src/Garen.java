import java.util.Random;

public class Garen extends Hero{


    public void attack(TIMO timo){
        int left = 0;
        int anotherHeroLeftHP = 0;
        //盖伦拿自己的攻击力去攻击传入的timo
        if(getAttack() <= timo.getHP()){
            //如果盖伦攻击力比被timo的血量还低 说明这次攻击不足以击杀对方
            //我们就把提莫的HP减去  减去的值应该是盖伦的攻击力
            anotherHeroLeftHP = timo.getHP() + this.getDefenNum() - getAttack();
            //然后把timo还剩下的血量设置回去
            timo.setHP(anotherHeroLeftHP);
            left = getAttack() - this.getDefenNum();
            System.out.println(this.getName() + "攻击了" + timo.getName() + "," + "敌方调用了自己的防御属性，"
            + timo.getName() + "实际受到的伤害为" + left + "，HP还剩" + timo.getHP());
        }else{
            System.out.println(this.getName() +"对提莫发出了最后一击！！！");
            // create random object
            Random randomno = new Random();

            // get next next boolean value
            boolean value = randomno.nextBoolean();
            if (value){
                System.out.println("可怜的提莫向召唤师提出了请求制裁蛮横的盖伦！！！");
                this.setHP(0);
                System.out.println("幸运女神眷顾了提莫,盖伦被和谐致死了...");
            }else {
                timo.setHP(0);
                System.out.println(this.getName() + "攻击了" + timo.getName() + "," + timo.getName() + "HP还剩0");
            }
        }

    }

    //获取获取技能并触发技能攻击效果
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



