package reghzy;

import com.google.common.collect.ArrayListMultimap;
import reghzy.cmdline.ArgsParser;
import reghzy.cmdline.CommandOptions;
import reghzy.cmdline.ParameterType;
import reghzy.graphics.collision.AxisAlignedBB;
import reghzy.graphics.collision.RayCast;
import reghzy.graphics.maths.Vector3;
import reghzy.helpers.Memory;

import java.sql.Array;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //CommandRegistry registry = new CommandRegistry();

        //registry.registerCommand("help", new HelpCommand());
        //registry.registerCommand("tile.something.say", new HelpCommand());
        //registry.registerCommand("ok.then", new HelpCommand());
        //ICommandExecutor help = registry.getCommand(null, "help");
        //ICommandExecutor say = registry.getCommand("tile.something", "say");
        //ICommandExecutor then = registry.getCommand("ok", "then");
        //ICommandExecutor ok = registry.getCommand(null, "ok");

        //AxisAlignedBB box1 = AxisAlignedBB.fromMinMax(new Vector3(0, 0, 0), new Vector3(1, 1, 1));
        //AxisAlignedBB box2 = AxisAlignedBB.fromMinMax(new Vector3(0.8f, 0.8f, 0.8f), new Vector3(1, 1, 1));
        //if (box2.intersectsAABB(box1)) {
        //    System.out.println("Intersects!");
        //}
        //else {
        //    System.out.println("No intersection");
        //}

        //char[] a = "hello".toCharArray();
        //char[] b = " ".toCharArray();
        //char[] c = "there".toCharArray();

        //ArrayListMultimap e;

        //System.out.println(Arrays.toString(output));

        ArgsParser parser = new ArgsParser(args);
        parser.addOptionToParse("name", ParameterType.string);
        parser.addOptionToParse("age", ParameterType.number);
        parser.addOptionToParse("group", ParameterType.string);
        parser.addOptionToParse("favSongs", ParameterType.stringArray);
        parser.addOptionToParse("data", ParameterType.subOptions);

        CommandOptions options = parser.parse();

        //Vector3 a = new Vector3(0, 0, 0);
        //Vector3 b = new Vector3(0, 0, 0);
        //for(float c = 0.0f; c < 2.0f; c += 0.1f) {
        //    b.x = c;
        //    float angle = a.angle(b);
        //    System.out.println(angle);
        //}

        System.out.println("okay then");

        // value, 0, value.length, str.value, 0, str.value.length, 0

        long nanoC = System.nanoTime();
        testJava();
        long nanoD = System.nanoTime();

        long nanoA = System.nanoTime();
        testMine();
        long nanoB = System.nanoTime();

        long myDifference = nanoB - nanoA;
        long javaDifference = nanoD - nanoC;
        System.out.println("Mine - Milliseconds: " + ((float) myDifference / 1000000.0f));
        System.out.println("Java - Milliseconds: " + ((float) javaDifference / 1000000.0f));

        System.out.println("ok");
    }

    public static void testMine() {
        ArrayList<Integer> aa = new ArrayList<Integer>(1000000);
        char[] a = "hello".toCharArray();
        char[] b = "el".toCharArray();
        for (int i = 0; i < 1000000; i++) {
            aa.add(Memory.indexOf(a, b));
        }
    }

    public static void testJava() {
        ArrayList<Integer> bb = new ArrayList<Integer>(1000000);
        String c = "hello";
        String d = "el";
        for (int i = 0; i < 1000000; i++) {
            bb.add(c.indexOf(d));
        }
    }
}
