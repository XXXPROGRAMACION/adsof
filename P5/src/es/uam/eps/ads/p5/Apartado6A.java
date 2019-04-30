package es.uam.eps.ads.p5;

public class Apartado6A {

    public static void main(String[] args) {
        System.out.println("Se crea el Agente A");
        IAgent agentA = new Agent("Agente A");

        System.out.println("Se establece la propiedad del Agente A a 1");
        agentA.set("Propiedad", 1);

        System.out.println("Se hace una copia del Agente A, el Agente B");
        IAgent agentB = (IAgent) agentA.copy();

        System.out.println("Se establece la propiedad del Agente B a 2");
        agentB.set("Propiedad", 2);

        System.out.println("Se hace otra copia del Agente A, el Agente C");
        IAgent agentC = (IAgent) agentA.copy();
        
        System.out.print("El valor de la propiedad del agente A es " + agentA.get("Propiedad"));
        if (agentA.get("Propiedad") == 1) System.out.print(" (Correcto)\n");
        else System.out.print(" (Incorrecto)\n");

        System.out.print("El valor de la propiedad del agente B es " + agentB.get("Propiedad"));
        if (agentB.get("Propiedad") == 2) System.out.print(" (Correcto)\n");
        else System.out.print(" (Incorrecto)\n");

        System.out.print("El valor de la propiedad del agente C es " + agentC.get("Propiedad"));
        if (agentC.get("Propiedad") == 1) System.out.print(" (Correcto)\n");
        else System.out.print(" (Incorrecto)\n");
    }
}