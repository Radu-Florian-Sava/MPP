package network.utils;

import network.rpc.ams.ClientAMSRpcReflectionWorker;
import services.IServicesAMS;

import java.net.Socket;


public class RpcAMSConcurrentServer extends AbsConcurrentServer {
    private IServicesAMS server;
    public RpcAMSConcurrentServer(int port, IServicesAMS server) {
        super(port);
        this.server= server;
        System.out.println("RpcAMSConcurrentServer port "+port);
    }

    @Override
    protected Thread createWorker(Socket client) {
        ClientAMSRpcReflectionWorker worker=new ClientAMSRpcReflectionWorker(server, client);

        Thread tw=new Thread(worker);
        return tw;
    }
}
