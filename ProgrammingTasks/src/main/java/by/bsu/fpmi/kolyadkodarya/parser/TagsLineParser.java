package by.bsu.fpmi.kolyadkodarya.parser;

/**
 * Created by Даша on 20.12.2015.
 */
public class TagsLineParser
{
    public static String[] parseTagsLine(String line)
    {
        return line.split("\\s+");
    }
}