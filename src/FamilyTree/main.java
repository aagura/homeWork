package FamilyTree;

import FamilyTree.File.FileHandler;
import FamilyTree.tree.Person;
import FamilyTree.tree.Tree;

import java.io.IOException;
import java.time.LocalDate;

import static FamilyTree.tree.Sex.Female;
import static FamilyTree.tree.Sex.Male;

public class main {
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        Tree tree = new Tree ();

        tree.addPerson (new Person("Иван Федорович Крузенштерн", Male, LocalDate.of(1975,07,10 )));
        tree.addPerson (new Person("Вероника Степановна Кулебякина", Female, LocalDate.of(1977,06,10 )));
        tree.addPerson (new Person("Дядя Федор", Male, LocalDate.of(1995,06,01 )));
        tree.addPerson (new Person("Жучка", Female, LocalDate.of(1997,06,01 )));
        tree.getByName("Иван Федорович Крузенштерн").addChild (tree.getByName("Дядя Федор"));
        tree.getByName("Иван Федорович Крузенштерн").addChild (tree.getByName("Жучка"));

        //tree.getByName ("Иван Федорович Крузенщтерн").addDd (LocalDate.of(2022,07,10 ));
       // tree.coonectSpouse ("Иван Федорович Крузенщтерн","Вероника Степановна Кулебякина");

        System.out.println(tree.getInfo());
        System.out.println(tree.getByName("Иван Федорович Крузенштерн").getChildrenInfo());
        System.out.println(tree.getByName("Вероника Степановна Кулебякина").getChildrenInfo());

        FileHandler fh= new FileHandler();
        fh.save(tree);
        Tree RessoredTree = fh.load ();

        System.out.println(RessoredTree.getInfo());
        System.out.println(RessoredTree.getByName("Иван Федорович Крузенштерн").getChildrenInfo());
        System.out.println(RessoredTree.getByName("Вероника Степановна Кулебякина").getChildrenInfo());

        tree.sortAge();
        System.out.println(tree.getInfo());
        tree.sortName();
        System.out.println(tree.getInfo());

        for (Person person: tree){
            System.out.println (person.getName());
        }




    }


}
