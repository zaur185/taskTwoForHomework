package gameplayer;

import gameplay.Gameplay;
import parserXML.ParserXML;
import table.Table;

public class Gameplayer {
        ParserXML parserXML=new ParserXML();
        Gameplay gameplay = parserXML.parsingXML();
        Table table = new Table();

        public void playingGame(){
                table.outputTable(gameplay);
        }


}
