package model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Tournament {

    private Participant firstParticipant;
    private Spectator firstSpectator;

    public void loadSpectators(String filePath) {

        try {
            FileReader spectatorsFile = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(spectatorsFile);
            String line;
            String[] splitLine;
            line = reader.readLine();
            splitLine = line.split(",");
            firstSpectator = new Spectator(splitLine[0], splitLine[1], splitLine[2], splitLine[3],
                    splitLine[4], splitLine[5], splitLine[6], splitLine[7]);

            while (line != null) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                splitLine = line.split(",");
                Spectator newSpectator = new Spectator(splitLine[0], splitLine[1], splitLine[2], splitLine[3],
                        splitLine[4], splitLine[5], splitLine[6], splitLine[7]);
                insertSpectator(firstSpectator, newSpectator);
            }

            reader.close();
            spectatorsFile.close();
        } catch (Exception ignored) {

        }
    }

    public void insertSpectator(Spectator currentRoot, Spectator spectator) {//Inserts elements into the tree.
        if (compareSpectators(spectator, currentRoot) == -1) {
            if (currentRoot.getLeftSpectator() == null) {
                currentRoot.setLeftSpectator(spectator);
            } else {
                insertSpectator(currentRoot.getLeftSpectator(), spectator);
            }
        } else {
            if (currentRoot.getRightSpectator() == null) {
                currentRoot.setRightSpectator(spectator);
            } else {
                insertSpectator(currentRoot.getRightSpectator(), spectator);
            }
        }
    }

    public void insertParticipant(Participant participant) {//Inserts a new participant into the list from the binary tree
        if (firstParticipant == null) {
            firstParticipant = participant;
        } else {
            if (firstParticipant.nextParticipant == null) {
                if (compareSpectators(participant, firstParticipant) == -1) {
                    Participant temp = firstParticipant;
                    firstParticipant = participant;
                    firstParticipant.nextParticipant = temp;
                    temp.previousParticipant = firstParticipant;
                } else {
                    firstParticipant.nextParticipant = participant;
                    participant.previousParticipant = firstParticipant;
                }
            } else {
                Participant actualParticipant = firstParticipant;
                while (actualParticipant.nextParticipant != null) {
                    if (participant.getId() < actualParticipant.getId()) {
                        Participant temp = actualParticipant;
                        actualParticipant = participant;
                        actualParticipant.nextParticipant = temp;
                        actualParticipant.previousParticipant = temp.previousParticipant;
                        temp.previousParticipant = actualParticipant;
                    }
                }
            }
        }
    }

    public void selectParticipants(Spectator currentRoot) {//Selects spectators from the tree and loads them into a new linked list
        Random rng = new Random();

        if (firstParticipant == null) {
            if (rng.nextInt(1) == 1) {
                firstParticipant = new Participant(currentRoot);
            }
            if (currentRoot.getLeftSpectator() != null) {
                selectParticipants(currentRoot.getLeftSpectator());
            }
            if (currentRoot.getRightSpectator() != null) {
                selectParticipants(currentRoot.getRightSpectator());
            }
        } else {
            if (rng.nextInt(1) == 1) {
                insertParticipant(new Participant(currentRoot));
            }
            if (currentRoot.getLeftSpectator() != null) {
                selectParticipants(currentRoot.getLeftSpectator());
            }
            if (currentRoot.getRightSpectator() != null) {
                selectParticipants(currentRoot.getRightSpectator());
            }
        }

    }

    public Spectator searchSpectator(int id, Spectator currentRoot) {
        if (currentRoot.getId() == id || currentRoot == null) {
            return currentRoot;
        }
        if (id < currentRoot.getId()) {
            return searchSpectator(id, currentRoot.getLeftSpectator());
        }
        return searchSpectator(id, currentRoot.getRightSpectator());
    }

    public Participant searchParticipant(int id, Participant participant) {
        if (participant == null) {
            return participant;
        }
        if (participant.getId() == id)
            return participant;
        return searchParticipant(id, participant.nextParticipant);
    }

    private int compareSpectators(Spectator spec1, Spectator spec2) {//Compares two Spectators based on their Id
        int lowest;
        if (spec1.getId() < spec2.getId()) {
            lowest = -1;
        } else {
            lowest = 1;
        }
        return lowest;
    }

    public Participant getFirstParticipant() {
        return firstParticipant;
    }

    public Spectator getFirstSpectator() {
        return firstSpectator;
    }
}
