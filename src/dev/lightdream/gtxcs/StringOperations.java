package dev.lightdream.gtxcs;

public class StringOperations {
    public static void main(String[] args) {
        String name = "Radu";
        System.out.println(name);
        name = "A" + name.substring(1, name.length() - 2) + "Z";
        System.out.println(name);
        String url = "www.lightdream.dev";
        System.out.println(url);
        url = url.substring(url.indexOf(".") + 1);
        url = url.substring(0, url.indexOf("."));
        url += "1337";
        System.out.println(url);
    }
}
