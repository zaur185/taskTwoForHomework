package testcase;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import gameplay.Gameplay;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class WriterHistory{


        public  void  createGameplaySource(Gameplay gameplay) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            try {
                builder = factory.newDocumentBuilder();

                Document doc = builder.newDocument();

                Element rootElement = doc.createElement("GamePlay");

                doc.appendChild(rootElement);

                for(int i = 0; i <gameplay.getStepArrayList().size();i++){

                    rootElement.appendChild(getStep(doc,
                            gameplay.getStepArrayList().get(i).getIdStep(),
                            gameplay.getStepArrayList().get(i).getIndexI(),
                            gameplay.getStepArrayList().get(i).getIndexJ(),
                            gameplay.getStepArrayList().get(i).getPlayerID()));

                }




                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);


                StreamResult console = new StreamResult(System.out);
                StreamResult file = new StreamResult(new File("gameplay.xml"));

                //записываем данные
                transformer.transform(source, console);
                transformer.transform(source, file);
                System.out.println("Yep");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        private static Node getStep(Document doc, String id, String indexI, String indexJ, String playerId) {
            Element language = doc.createElement("Step");

            // устанавливаем атрибут id
            language.setAttribute("id", id);

            // создаем элемент indexI
            language.appendChild(getLanguageElements(doc, language, "indexI", indexI));

            // создаем элемент indexJ
            language.appendChild(getLanguageElements(doc, language, "indexJ", indexJ));

            // создаем элемент playerID
            language.appendChild(getLanguageElements(doc, language, "playerID", playerId));
            return language;
        }



        private static Node getLanguageElements(Document doc, Element element, String name, String value) {
            Element node = doc.createElement(name);
            node.appendChild(doc.createTextNode(value));
            return node;
        }


}
