import java.awt.*;
import java.io.*;
import javax.swing.*;

public class TextEditor extends JFrame {

    JTextArea textArea;
    String filePath = null;

    public TextEditor() {
        setTitle("Text Editor");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setJMenuBar(createMenuBar());
    }

    JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(e -> newFile());

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(e -> openFile());

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> saveFile());

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");

        JMenuItem cut   = new JMenuItem("Cut");
        JMenuItem copy  = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem selectAll = new JMenuItem("Select All");

        cut.addActionListener(e -> textArea.cut());
        copy.addActionListener(e -> textArea.copy());
        paste.addActionListener(e -> textArea.paste());
        selectAll.addActionListener(e -> textArea.selectAll());

        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(selectAll);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        return menuBar;
    }

    void newFile() {
        textArea.setText("");
        filePath = null;
        setTitle("Text Editor - New File");
    }

    void openFile() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            filePath = file.getAbsolutePath();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                reader.close();
                textArea.setText(content.toString());
                setTitle("Text Editor - " + file.getName());

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error: Could not open file.");
            }
        }
    }

    void saveFile() {
        if (filePath == null) {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showSaveDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                filePath = chooser.getSelectedFile().getAbsolutePath();
            } else {
                return;
            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(textArea.getText());
            writer.close();
            setTitle("Text Editor - " + new File(filePath).getName());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: Could not save file.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEditor().setVisible(true));
    }
}