package com.company;

import game.Game;
import gameplay.Gameplay;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.gameStarted();

//        Gameplay gameplay = null;
//
//        File file = new File("text.xml");
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        Document doc = null;
//
//        try {
//            doc = dbf.newDocumentBuilder().parse(file);
//        } catch (Exception e) {
//            System.out.println("Open parsing eror"+ e.toString());
//            return;
//        }
//
//        Node gameplayNode = doc.getFirstChild();
//
//        System.out.println("AAA" + gameplayNode.getNodeName());
//
//        NodeList gameplayChilds = gameplayNode.getChildNodes();
//        for(int i = 0 ; i<gameplayChilds.getLength();i++){
//            if(gameplayChilds.item(i).getNodeType() == Node.ELEMENT_NODE)
//            {
//                continue;
//            }
//            System.out.println("AAA" + gameplayChilds.item(i).getNodeName());
//        }

    }
}