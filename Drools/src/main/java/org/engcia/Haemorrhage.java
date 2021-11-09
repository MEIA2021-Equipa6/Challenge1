package org.engcia;

import org.engcia.model.Conclusion;

import java.util.*;
import org.engcia.model.Sensor;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.LiveQuery;
import org.kie.api.runtime.rule.Row;
import org.kie.api.runtime.rule.ViewChangedEventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Haemorrhage {
    static final Logger LOG = LoggerFactory.getLogger(Haemorrhage.class);
    public static List<Sensor> Sensors = new ArrayList<>();


    public static void main(String[] args) {
        Sensor sensor1 = new Sensor("AOCS", "Thermal", 1, 50);
        Sensor sensor2 = new Sensor("AOCS", "Voltage", 1, 5);
        Sensor sensor3 = new Sensor("AOCS", "Thermal", 2, 50);
        Sensor sensor4 = new Sensor("AOCS", "Voltage", 2, 5);
        Sensor sensor5 = new Sensor("Power" , "Thermal", 1, 80);
        Sensor sensor6 = new Sensor("Power", "Voltage", 1, 12);
        Sensor sensor7 = new Sensor("Power", "Thermal", 2, 10);
        Sensor sensor8 = new Sensor("Power", "Voltage",2, 12);
        Sensors.add(sensor1);
        Sensors.add(sensor2);
        Sensors.add(sensor3);
        Sensors.add(sensor4);
        Sensors.add(sensor5);
        Sensors.add(sensor6);
        Sensors.add(sensor7);
        Sensors.add(sensor8);

        runEngine(Sensors);
    }

    private static void runEngine(List<Sensor> sensors) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            final KieSession kSession = kContainer.newKieSession("ksession-rules");
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

                    // stop inference engine after as soon as got a conclusion
                    kSession.halt();

                }

                @Override
                public void rowUpdated(Row row) {
                }

            };
            LiveQuery query = kSession.openLiveQuery("Conclusions", null, listener);

            for (int i = 0; i < sensors.size(); i++) {
                kSession.insert(sensors.get(i));
            }



            kSession.fireAllRules();
            // kSession.fireUntilHalt();

            query.close();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
