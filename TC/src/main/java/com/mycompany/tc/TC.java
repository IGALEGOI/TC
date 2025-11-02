package com.mycompany.tc;

import BUS.NeighborhoodBUS;
import BUS.NeighborhoodPathBUS;
import BUS.TransportBUS;
import Entities.NeighborhoodEntity;
import Entities.NeighborhoodPathEntity;
import Entities.TransportEntity;
import java.util.List;

public class TC {

    public static void main(String[] args) {
//        TC.testTransport();
//        TC.testNeighborhood();
//        TC.testNeighborhoodPath();
    }
    
    public static void testTransport() {
        
        try {
              System.out.println("\n[TESTE] getTransportById()");
              TransportBUS bus = new TransportBUS();

              TransportEntity transport = bus.getTransportById(1);

              if (transport == null) {
                System.out.println("⚠️ Nenhum registro encontrado na tabela Transport.");
              } else {
                System.out.println("ID: " + transport.getId() + " | Model: " + transport.getModel() + " | MaxSpeed: " + transport.getMaxSpeed());
              }
        } catch (Exception e) {
            System.err.println("❌ Erro ao executar getTransport(): " + e.getMessage());
            e.printStackTrace();
        }
  
      try {
            System.out.println("\n[TESTE] getAllTransport()");
            TransportBUS bus = new TransportBUS();

            List<TransportEntity> transportList = bus.getAllTransport();

            if (transportList == null || transportList.isEmpty()) {
                System.out.println("⚠️ Nenhum registro encontrado na tabela Transport.");
            } else {
                System.out.println("✅ Total de registros: " + transportList.size());
                for (TransportEntity t : transportList) {
                    System.out.println("ID: " + t.getId() + " | Model: " + t.getModel() + " | MaxSpeed: " + t.getMaxSpeed());
                }
            }
        } catch (Exception e) {
            System.err.println("❌ Erro ao executar getTransport(): " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void testNeighborhood() {
        
        try {
            System.out.println("\n[TESTE] getAllNeighborhood()");
            NeighborhoodBUS bus = new NeighborhoodBUS();

            List<NeighborhoodEntity> neighborhoodList = bus.getAllNeighborhood();

            if (neighborhoodList == null || neighborhoodList.isEmpty()) {
                System.out.println("⚠️ Nenhum registro encontrado na tabela Neighborhood.");
            } else {
                System.out.println("✅ Total de registros: " + neighborhoodList.size());
                for (NeighborhoodEntity n : neighborhoodList) {
                    System.out.println("Name: " + n.getName());
                }
            }
        } catch (Exception e) {
            System.err.println("❌ Erro ao executar getAllNeighborhood(): " + e.getMessage());
            e.printStackTrace();
        }

        try {
            System.out.println("\n[TESTE] getNeighborhoodByName()");
            NeighborhoodBUS bus = new NeighborhoodBUS();
            
            NeighborhoodEntity neighborhood = bus.getNeighborhoodByName("Centro"); 

            if (neighborhood == null) {
                System.out.println("⚠️ Nenhum registro encontrado com o nome especificado.");
            } else {
                System.out.println("Name: " + neighborhood.getName());
            }
        } catch (Exception e) {
            System.err.println("❌ Erro ao executar getNeighborhoodByName(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testNeighborhoodPath() {
        
        try {
            System.out.println("\n[TESTE] getAllNeighborhoodPath()");
            NeighborhoodPathBUS bus = new NeighborhoodPathBUS();

            List<NeighborhoodPathEntity> pathList = bus.getAllNeighborhood(); 

            if (pathList == null || pathList.isEmpty()) {
                System.out.println("⚠️ Nenhum registro encontrado na tabela NeighborhoodPath.");
            } else {
                System.out.println("✅ Total de registros: " + pathList.size());
                for (NeighborhoodPathEntity p : pathList) {
                    System.out.println("ID: " + p.getId() + " | FromID: " + p.getFromId() + " | ToID: " + p.getToId());
                }
            }
        } catch (Exception e) {
            System.err.println("❌ Erro ao executar getAllNeighborhoodPath(): " + e.getMessage());
            e.printStackTrace();
        }

        try {
            System.out.println("\n[TESTE] getNeighborhoodByDirection()");
            NeighborhoodPathBUS bus = new NeighborhoodPathBUS();
            
            NeighborhoodPathEntity path = bus.getNeighborhoodByDirection("Aeroporto", "Casa Branca");

            if (path == null) {
                System.out.println("⚠️ Nenhum caminho encontrado para a direção especificada.");
            } else {
                System.out.println("ID: " + path.getId() + " | FromID: " + path.getFromId() + " | ToID: " + path.getToId());
            }
        } catch (Exception e) {
            System.err.println("❌ Erro ao executar getNeighborhoodByDirection(): " + e.getMessage());
            e.printStackTrace();
        }
    }
}