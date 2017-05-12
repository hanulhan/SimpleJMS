/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.jms.simple;

import org.apache.activemq.broker.BrokerService;

/**
 *
 * @author uhansen
 */
public class Broker {

    public Broker() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();
        broker.setUseJmx(true);
        broker.addConnector("tcp://localhost:61616");
        broker.start();

        // now lets wait forever to avoid the JVM terminating immediately
        Object lock = new Object();
        synchronized (lock) {
            lock.wait();
        }
    }

}
