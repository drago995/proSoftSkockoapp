/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commonskocko;

/**
 *
 * @author Ljubomir
 */
public class main {

    public static void main(String[] args) {
        
        CommonSkocko skocko = new CommonSkocko(1, 2, 3, 4);
        CommonSkocko resenje = new CommonSkocko(1, 2, 5, 4);
        
        System.out.println(skocko.getPogodjeniNaMestu(resenje));
         System.out.println(skocko.getPogodjeniNisuNaMestu(resenje));
         System.out.println(skocko.pobedioJe());
         System.out.println(skocko.getKombinacija());

    }
}
