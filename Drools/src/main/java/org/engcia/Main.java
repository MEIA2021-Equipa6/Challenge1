package org.engcia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.engcia.model.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.LiveQuery;
import org.kie.api.runtime.rule.Row;
import org.kie.api.runtime.rule.ViewChangedEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static KieSession KS;
    public static TrackingAgendaEventListener agendaEventListener;
    public static Map<Integer, Justification> justifications;
    static final Logger LOG = LoggerFactory.getLogger(Main.class);
    public static List<Sensor> sensors = new ArrayList<>();

    //private final static String FILE = "/home/cristiano/IdeaProjects/Challenge1/Drools/src/main/resources/file.json";
    private final static String FILE = "C:\\Users\\darkj\\Documents\\GitHub\\Challenge1\\Drools\\src\\main\\resources\\file.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String getJsonFile(){
        try {
            String json = new String(Files.readAllBytes(Paths.get(FILE)));
            // if(!StringUtils.isEmpty(json)) {
                //Files.delete(Path.of(FILE));
            //}
            return json;
        } catch (IOException e) {
            return null;
        }
    }

    public static void readSensorValuesFromFile(){
        String json = getJsonFile();
        if(json != null){
            try {
                sensors = mapper.readValue(json, new TypeReference<>() {});
                runEngine(sensors);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO: Remove this method
    public static void testMethod(){
        Sensor sensor1 = new Sensor("AOCS", "Thermal", 1, 10);
        Sensor sensor2 = new Sensor("AOCS", "Voltage", 1, 30);
        Sensor sensor3 = new Sensor("AOCS", "Thermal", 2, 50);
        Sensor sensor4 = new Sensor("AOCS", "Voltage", 2, 29);
        Sensor sensor5 = new Sensor("Power" , "Thermal", 1, 80);
        Sensor sensor6 = new Sensor("Power", "Voltage", 1, 12);
        Sensor sensor7 = new Sensor("Power", "Thermal", 2, 10);
        Sensor sensor8 = new Sensor("Power", "Voltage",2, 12);
        Sensor sensor9 = new Sensor("AOCS", "Switch",1, 1);
        Sensor sensor10 = new Sensor("Power", "Thermal", 1, 1);
        Sensor sensor11 = new Sensor("AOCS", "Current",1, 0);
        Sensor sensor12 = new Sensor("AOCS", "Current",2, 0);
        sensors.add(sensor1);
        sensors.add(sensor2);
        sensors.add(sensor3);
        sensors.add(sensor4);
        sensors.add(sensor5);
        sensors.add(sensor6);
        sensors.add(sensor7);
        sensors.add(sensor8);
        sensors.add(sensor9);
        sensors.add(sensor10);
        sensors.add(sensor11);
        sensors.add(sensor12);
        runEngine(sensors);
    }


    public static void main(String[] args) throws InterruptedException {
       testMethod();
       //readSensorValuesFromFile();
    }

    private static void runEngine(List<Sensor> sensors) {
        try {
            Main.justifications = new TreeMap<>();
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            final KieSession kSession = kContainer.newKieSession("ksession-rules");
            Main.KS = kSession;
            Main.agendaEventListener = new TrackingAgendaEventListener();
            kSession.addEventListener(agendaEventListener);
            // session name defined in kmodule.xml"

            // Query listener
            ViewChangedEventListener listener = new ViewChangedEventListener() {
                @Override
                public void rowDeleted(Row row) {
                }

                @Override
                public void rowInserted(Row row) {
                    Conclusion conclusion = (Conclusion) row.get("$conclusion");
                    //System.out.println(">>>" + conclusion.toString());
                    LOG.info(">>>" + conclusion.toString());


                    How how = new How(Main.justifications);
                    System.out.println(how.getHowExplanation(conclusion.getId()));
                    // stop inference engine after as soon as got a conclusion
                   // kSession.halt();

                }

                @Override
                public void rowUpdated(Row row) {
                }

            };
            LiveQuery query = kSession.openLiveQuery("Conclusions", null, listener);

            for (Sensor sensor : sensors) {
                kSession.insert(sensor);
            }



            kSession.fireAllRules();
            // kSession.fireUntilHalt();

            query.close();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
