import java.util.Scanner;
/**
 *
 * @author moneyshot
 */
public class Garyland {

    public static class Character{
        int hp = 100;
        int lvl = 1;
        int exp = 0;
        int gold = 0;
        int item = 0;
        String name;
        void Character(){
          
        }
        int attack(){
            return lvl *  3;
        }
        
        int levelUp(){
            return lvl++;
        }
        int findGold(int goldFound){
            gold = goldFound;
            return gold;
        }
        void addItem(int item){
            this.item = item;
        }
    } 
        public static class Monster{
        int hp;
        int lvl;
        int expGiven;
        int goldGiven;
    
        Monster(){
        
        }
        void setStats(int hitpoints,int level,int exp, int gold){
            this.hp = hitpoints;
            this.lvl = level;
            this.expGiven = exp;
            this.goldGiven = gold;
        }
        int monsterAttack(){
            return lvl * Math.round(Math.round(Math.random()));
        }
        int setDamage(){
            return 10;
        }
        
        
    }
        public static class Item{
            int heal;
            int price;
            
          Item(int hpHealed,int price){
             this.heal = hpHealed;
              this.price = price; 
          }  
          
        }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter your character's name: ");
        String input = read.nextLine();
        
        Character chara = new Character();
        chara.name = input;
        
        System.out.println("Hello " + chara.name + "!");
        read.nextLine();
        System.out.println("Welcome to Garyland!");
        System.out.println("You wake up in a forest, shrouded by darkness.");
        System.out.println("Next to you is a sword and a shield.");
        System.out.println("You stand up and observe your surroundings");
        System.out.println("You see two paths that split into two directions.");
        System.out.println("Will you go left or right?");
        String direction = read.nextLine();
        
        if(direction.charAt(0)=='r'){
            System.out.println("you turn right and find 2 gold and a dead end.");
            chara.findGold(2);
            read.nextLine();
            System.out.println("you decide to head back.");
            read.nextLine();
        }
        System.out.println("You decide to go on the left path.");
        System.out.println("As you walk, you hear some rustling in the darkness.");
        System.out.println("A bandit ambushes you!");
        System.out.println("enter A to attack, B to block, or C to run!");
        Monster bandit = new Monster();
        bandit.setStats(25, 1, 15, 10);
        
        do{
           
            String action = read.nextLine();
           
            switch(action.charAt(0)){
               case('A'):
                   bandit.hp = bandit.hp - chara.attack();
                   System.out.println("You swing at the bandit.");
                   System.out.println("you deal " + chara.attack() + " damage!");
                   System.out.println("the bandit's hp is "+ bandit.hp + ".");
                   System.out.println("The bandit retaliates!");
                   chara.hp = chara.hp - bandit.monsterAttack();
                   System.out.println("your hp is " + chara.hp + ".");
                   break;
               case('B'):
                   chara.hp = chara.hp + bandit.monsterAttack() - bandit.monsterAttack();
                   System.out.println("You block the attack!");
                   break;
               case('C'):
                   System.out.println("You run for your life!");
                   break;
               default:
                  System.out.println("enter A to attack, B to block, or C to run!");
                 
               }
        
        
        
        } while(bandit.hp > 0);
        
        if (bandit.hp <= 0){
            System.out.println("You won " + bandit.goldGiven +" gold!");
            System.out.println("you gained " + bandit.expGiven + " exp");
            chara.gold += bandit.goldGiven;
            chara.exp += bandit.expGiven;
            
            read.nextLine();
            System.out.println("You are about to take the final swing to end it.");
        
        System.out.println("Bandit: No please spare me! ");
        read.nextLine();
        System.out.println("Bandit: If you do I will show you where I hid my treasure.");
        read.nextLine();
        System.out.println("Spare him?");
        System.out.println ("enter yes or no");
        String decision = read.nextLine();
            if (decision.charAt(0) == 'y' || decision.charAt(0) == 'Y'){
                System.out.println("You spare the bandit.");
                System.out.println("Bandit: Thanks mate.");
                System.out.println("Bandit: But i'll never show you where my treasure is!");
                System.out.println("The bandit swings at you!");
                chara.hp = chara.hp - bandit.setDamage();
                System.out.println("You took " + bandit.setDamage() +" damage!");
                System.out.println("You swing back and end his sorry ass");
                System.out.println("You continue onward through the path");
            }
            else{
                System.out.println("You decide to end his life.");
                System.out.println("You feel bad, but you decide to continue onward");
            }
        
  }
            
            System.out.println("As you continue walking, you see a dim light shining through ome trees.");
            System.out.println("You walk to toward the light.");
            System.out.println("As you get closer, the light appears to be a town!");
            System.out.println("You see a sign that says 'Blue Tree Village'");
            Item apple = new Item(15,5);
            System.out.println("You see a apple seller.");
            System.out.println("Buy an apple?");
            System.out.println("Yes or No");
            String buyApple = read.nextLine();
            if (buyApple.charAt(0)== 'y' || buyApple.charAt(0)=='Y'){
                chara.item = 1;
            }
            
        
    }
    
    
}
