package parserXML;

import gameplay.Gameplay;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ParserXML {

    public Gameplay parsingXML(){
    Gameplay gameplay = new Gameplay();
    Document doc = null;

        try {
        doc = buildDocument();
    } catch (Exception e) {
        System.out.println("Open parsing eror" + e.toString());
        return null;
    }

    Node gameplayNode = doc.getFirstChild();
        System.out.println("AAA" + gameplayNode.getNodeName());
    NodeList gameplayChildren = gameplayNode.getChildNodes();

    Node stepNode = null;
        for (int i = 0; i < gameplayChildren.getLength(); i++) {
        if (gameplayChildren.item(i).getNodeType() == Node.ELEMENT_NODE) {
            continue;
        }
        if (!gameplayChildren.item(i).getNodeName().equals("Step")) {
            continue;
        }


        int indexI = 0;
        int indexJ = 0;
        int playerID = 0;


        NodeList stepChilds = gameplayChildren.item(i).getChildNodes();
        for (int j = 0; j < stepChilds.getLength(); j++) {
            if (stepChilds.item(j).getNodeType() == Node.ELEMENT_NODE) {
                continue;
            }
            switch (stepChilds.item(j).getNodeName()) {
                case "indexI": {
                    indexI = Integer.valueOf(stepChilds.item(j).getTextContent());
                }
                case "indexJ": {

                    indexJ = Integer.valueOf(stepChilds.item(j).getTextContent());
                }
                case "playerID": {
                    playerID = Integer.valueOf(stepChilds.item(j).getTextContent());

                }
            }
        }
        gameplay.addStep(indexI, indexJ, playerID);
    }
        return gameplay;
}

    private static Document buildDocument() {
        File file = new File("gameplay.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            return dbf.newDocumentBuilder().parse(file);
        } catch (Exception e) {
            System.out.println("Open parsing eror" + e.toString());
            return null;
        }
    }
}
