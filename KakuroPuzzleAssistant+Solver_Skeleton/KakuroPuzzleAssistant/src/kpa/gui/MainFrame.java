//# BEGIN SKELETON
package kpa.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import kpa.model.KPuzzle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import kpa.command.Command;
import kpa.command.CompoundCommand;
import kpa.command.SetCommand;
import kpa.command.UndoRedo;
import kpa.model.KCell;
import kpa.reasoning.EmptyCellReasoner;
import kpa.reasoning.Reasoner;
import kpa.reasoning.EntryWithOneEmptyCell;
import kpa.reasoning.FixpointReasoner;
//# BEGIN TODO imports for extra reasoners
// Replace this line
//# END TODO
import kpa.solvers.AbstractSolver;
import kpa.solvers.BacktrackSolver;

/**
 * Main frame for Kakuro Puzzle Assistant,
 * that mainly implements the controller.
 *
 * @author Tom Verhoeff (Eindhoven University of Technology)
<!--//# BEGIN TODO Name, id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 2.04.2017</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame.
     */
    public MainFrame() {
        initComponents();
        puzzlePanel = ((PuzzlePanel) jPanelPuzzle);
        initFrame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jPanelPuzzle = new kpa.gui.PuzzlePanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jMenuItemDump = new javax.swing.JMenuItem();
        jSeparatorFile1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemQuit = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemUndo = new javax.swing.JMenuItem();
        jMenuItemUndoAll = new javax.swing.JMenuItem();
        jMenuItemRedo = new javax.swing.JMenuItem();
        jMenuItemRedoAll = new javax.swing.JMenuItem();
        jMenuItemClear = new javax.swing.JMenuItem();
        jSeparatorEdit1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCopy = new javax.swing.JMenuItem();
        jMenuItemClearTextArea = new javax.swing.JMenuItem();
        jSeparatorEdit2 = new javax.swing.JPopupMenu.Separator();
        jRadioButtonMenuItemView = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemSolve = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemEdit = new javax.swing.JRadioButtonMenuItem();
        jMenuPuzzle = new javax.swing.JMenu();
        jCheckBoxMenuItemHighlight = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemApplyStrategies = new javax.swing.JMenuItem();
        jCheckBoxMenuItemStopAtFirstChange = new javax.swing.JCheckBoxMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSolve = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemHelp = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea.setEditable(false);
        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        jPanelPuzzle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelPuzzleMouseClicked(evt);
            }
        });
        jPanelPuzzle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanelPuzzleKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelPuzzleLayout = new javax.swing.GroupLayout(jPanelPuzzle);
        jPanelPuzzle.setLayout(jPanelPuzzleLayout);
        jPanelPuzzleLayout.setHorizontalGroup(
            jPanelPuzzleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        jPanelPuzzleLayout.setVerticalGroup(
            jPanelPuzzleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuFile.setText("File");

        jMenuItemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNew.setText("New…");
        jMenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNew);

        jMenuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpen.setText("Open…");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpen);

        jMenuItemSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSaveAs.setText("Save As…");
        jMenuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveAsActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSaveAs);

        jMenuItemDump.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDump.setText("Dump");
        jMenuItemDump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDumpActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemDump);
        jMenuFile.add(jSeparatorFile1);

        jMenuItemQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemQuit.setText("Quit");
        jMenuItemQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemQuitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemQuit);

        jMenuBar1.add(jMenuFile);

        jMenuEdit.setText("Edit");

        jMenuItemUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUndo.setText("Undo");
        jMenuItemUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUndoActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemUndo);

        jMenuItemUndoAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUndoAll.setText("Undo All");
        jMenuItemUndoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUndoAllActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemUndoAll);

        jMenuItemRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRedo.setText("Redo");
        jMenuItemRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRedoActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemRedo);

        jMenuItemRedoAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRedoAll.setText("Redo All");
        jMenuItemRedoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRedoAllActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemRedoAll);

        jMenuItemClear.setText("Clear");
        jMenuItemClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClearActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemClear);
        jMenuEdit.add(jSeparatorEdit1);

        jMenuItemCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCopy.setText("Copy");
        jMenuItemCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCopyActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemCopy);

        jMenuItemClearTextArea.setText("Clear Messages");
        jMenuItemClearTextArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClearTextAreaActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemClearTextArea);
        jMenuEdit.add(jSeparatorEdit2);

        jRadioButtonMenuItemView.setText("View Mode");
        jRadioButtonMenuItemView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemViewActionPerformed(evt);
            }
        });
        jMenuEdit.add(jRadioButtonMenuItemView);

        jRadioButtonMenuItemSolve.setText("Solve Mode");
        jRadioButtonMenuItemSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemSolveActionPerformed(evt);
            }
        });
        jMenuEdit.add(jRadioButtonMenuItemSolve);

        jRadioButtonMenuItemEdit.setText("Edit Mode");
        jRadioButtonMenuItemEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemEditActionPerformed(evt);
            }
        });
        jMenuEdit.add(jRadioButtonMenuItemEdit);

        jMenuBar1.add(jMenuEdit);

        jMenuPuzzle.setText("Puzzle");

        jCheckBoxMenuItemHighlight.setSelected(true);
        jCheckBoxMenuItemHighlight.setText("Highlight");
        jCheckBoxMenuItemHighlight.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxMenuItemHighlightItemStateChanged(evt);
            }
        });
        jMenuPuzzle.add(jCheckBoxMenuItemHighlight);
        jMenuPuzzle.add(jSeparator1);

        jMenuItemApplyStrategies.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemApplyStrategies.setText("Apply Reasoning");
        jMenuItemApplyStrategies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemApplyReasoningActionPerformed(evt);
            }
        });
        jMenuPuzzle.add(jMenuItemApplyStrategies);

        jCheckBoxMenuItemStopAtFirstChange.setSelected(true);
        jCheckBoxMenuItemStopAtFirstChange.setText("Stop at First Change");
        jCheckBoxMenuItemStopAtFirstChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemStopAtFirstChangeActionPerformed(evt);
            }
        });
        jMenuPuzzle.add(jCheckBoxMenuItemStopAtFirstChange);
        jMenuPuzzle.add(jSeparator2);

        jMenuItemSolve.setText("Solve");
        jMenuItemSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSolveActionPerformed(evt);
            }
        });
        jMenuPuzzle.add(jMenuItemSolve);

        jMenuItem1.setText("Abort");
        jMenuItem1.setEnabled(false);
        jMenuPuzzle.add(jMenuItem1);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Stop at First Solution");
        jMenuPuzzle.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Dump Solutions");
        jMenuPuzzle.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMenuPuzzle);

        jMenuHelp.setText("Help");

        jMenuItemHelp.setText("Help");
        jMenuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHelpActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemHelp);

        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemAbout);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPuzzle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelPuzzle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveAsActionPerformed
        if (puzzle == null) {
            jTextArea.append("No puzzle to save.\n");
            return;
        }
        int result = puzzleChooser.showSaveDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) {
            jTextArea.append("Save canceled by user.\n");
            return; // canceled or error
        }
        File puzzleFile = puzzleChooser.getSelectedFile();
        if (puzzleFile.exists ()) {
            int response = JOptionPane.showConfirmDialog(this,
                    "Overwrite existing file?",
                    "Confirm Overwrite",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.CANCEL_OPTION) {
                jTextArea.append("Overwrite canceled by user.\n");
                return;
            }
        }
        // can write puzzleFile
        PrintWriter out;
        try {
            out = new PrintWriter(puzzleFile);
            out.print(puzzle);
            out.close();
            unsavedModifications = false;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                    "IO error while saving file: " + e,
                    "File Save Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemSaveAsActionPerformed

    private void jMenuItemQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemQuitActionPerformed
        if (! confirmDiscard()) {
            return;
        }
        // Maybe do some finalization first
        System.exit(0);
    }//GEN-LAST:event_jMenuItemQuitActionPerformed

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        if (! confirmDiscard()) {
            return;
        }
        int result = puzzleChooser.showOpenDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) {
            jTextArea.append("Open canceled by user.\n");
            return; // canceled or error
        }
        File puzzleFile = puzzleChooser.getSelectedFile();
        final Scanner scanner;
        try {
            scanner = new Scanner(puzzleFile);
        } catch (FileNotFoundException e) {
            jTextArea.append("File not found:\n");
            jTextArea.append("  " + puzzleFile.getName() + "\n");
            jTextArea.append(e + "\n");
            return;
        }
        try {
            puzzle = new KPuzzle(scanner, puzzleFile.getName());
            this.setTitle("Kakuro Puzzle Assistant: " + puzzle.getName());
            jTextArea.append("Loaded puzzle from file " +
                    puzzle.getName() + "\n");
            jTextArea.append(puzzle.toString() + "\n");
            puzzlePanel.setPuzzle(puzzle);
            if (UNDO) {
//# BEGIN TODO Clear undo-redo facility
                undoRedo.clear();
//# END TODO
            }
            unsavedModifications = false;
            updateModeRadioButtons(KPuzzle.Mode.SOLVE);
            updateFrame();
        } catch (IllegalArgumentException e) {
            jTextArea.append("File does not contain a puzzle description:\n");
            jTextArea.append("  " + puzzleFile.getName() + "\n");
            jTextArea.append(e + "\n");
        }
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewActionPerformed
        jTextArea.append("New is not yet implemented.\n");
//        if (! confirmDiscard()) {
//            return;
//        }
//        Object[] possibleValues = { "4", "6", "8", "10", "12", "14" };
//        String value = (String)JOptionPane.showInputDialog(this,
//                "Select Size", "Input Size",
//                JOptionPane.INFORMATION_MESSAGE, null,
//                possibleValues, possibleValues[0]);
//        if (value == null || value.isEmpty()) {
//            return;
//        }
//        final int size = Integer.parseInt(value);
//        puzzle = new KPuzzle(new Scanner(
//                KPuzzle.makeEmptyDescriptor(size)),
//                "Untitled " + value + "x" + value);
//        this.setTitle("Kakuro Puzzle Assistant: " + puzzle.getName());
//        jTextArea1.append("Created new puzzle: " +
//                puzzle.getName() + "\n");
//        jTextArea1.append(puzzle.toString() + "\n");
//        puzzlePanel.setPuzzle(puzzle);
//        unsavedModifications = false;
//        updateModeRadioButtons(KPuzzle.Mode.EDIT);
//        updateFrame();
    }//GEN-LAST:event_jMenuItemNewActionPerformed

    private void jRadioButtonMenuItemViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemViewActionPerformed
        updateModeRadioButtons(KPuzzle.Mode.VIEW);
    }//GEN-LAST:event_jRadioButtonMenuItemViewActionPerformed

    private void jRadioButtonMenuItemSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemSolveActionPerformed
        updateModeRadioButtons(KPuzzle.Mode.SOLVE);
    }//GEN-LAST:event_jRadioButtonMenuItemSolveActionPerformed

    private void jRadioButtonMenuItemEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemEditActionPerformed
        updateModeRadioButtons(KPuzzle.Mode.EDIT);
    }//GEN-LAST:event_jRadioButtonMenuItemEditActionPerformed

    private void jPanelPuzzleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPuzzleMouseClicked
        if (evt.getClickCount() == 0) {
            return;
        }
        final KCell cell = puzzlePanel.mouseToCell(evt);
        if (cell == null) {
            return;
        }
        // cell != null

        if (cell != null & ! cell.isBlocked()) {
            // clicked an unblocked cell
            this.puzzlePanel.setSelected(cell);
            jTextArea.append("Selected cell " + cell.getLocation().toString()
                    + "\n");
        } else {
            this.puzzlePanel.setSelected(null);
        }
        updateFrame();
        jPanelPuzzle.requestFocusInWindow();
    }//GEN-LAST:event_jPanelPuzzleMouseClicked

    private void jPanelPuzzleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanelPuzzleKeyTyped
        jTextArea.append("Key typed: " + evt.getKeyChar() + "\n");
        if (puzzle == null) {
            return;
        }
        final KCell cell = this.puzzlePanel.getSelected();
        if (cell == null) {
            return;
        }
        // cell != null
        if (puzzle.getMode() != KPuzzle.Mode.SOLVE) {
            return;
        }

        // convert key typed to new state
        final char c = evt.getKeyChar();
        final int state;
        if ('1' <= c && c <= '9') {
            state = c - '0';
        } else if (c == '0' | c == ' ') {
            state = KCell.EMPTY;
        } else {
            return;
        }
        if (! UNDO) {
            cell.setState(state);
        } else {
//# BEGIN TODO Create undoable set command and pass it to undo-redo facility
            Command command = new SetCommand(cell, state);
            undoRedo.did(command);
//# END TODO
        }
        unsavedModifications = true;
        if (puzzle.isSolved()) {
            jTextArea.append("\n> > > Puzzle is SOLVED. < < <\n");
        }
        updateFrame();
    }//GEN-LAST:event_jPanelPuzzleKeyTyped

    private void jMenuItemDumpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDumpActionPerformed
        if (puzzle == null) {
            jTextArea.append("No puzzle to dump.\n");
            return;
        }
        jTextArea.append(puzzle.gridAsString());
    }//GEN-LAST:event_jMenuItemDumpActionPerformed

    private void jMenuItemCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCopyActionPerformed
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String selectedText = jTextArea.getSelectedText();
        // Wrap text into StringSelection to be able to put it in system clipboard
        StringSelection selection = new StringSelection(selectedText);
        // Check the API for other parameter of setContents() method
        clipboard.setContents(selection, null);
    }//GEN-LAST:event_jMenuItemCopyActionPerformed

    private void jMenuItemClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClearActionPerformed
        if (! confirmDiscard()) {
            return;
        }
        puzzle.clear();
        unsavedModifications = false;
        if (UNDO) {
//# BEGIN TODO Clear undo-redo facility
            undoRedo.clear();
//# END TODO
        }
        updateFrame();
    }//GEN-LAST:event_jMenuItemClearActionPerformed

    private void jMenuItemUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUndoActionPerformed
        if (! UNDO) {
            jTextArea.append("Undo is not yet implemented.\n");
        } else {
//# BEGIN TODO Undo last
            undoRedo.undo(true);
//# END TODO
            updateFrame();
        }
    }//GEN-LAST:event_jMenuItemUndoActionPerformed

    private void jMenuItemRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRedoActionPerformed
        if (! UNDO) {
            jTextArea.append("Redo is not yet implemented.\n");
        } else {
//# BEGIN TODO Redo last
            undoRedo.redo();
//# END TODO
            updateFrame();
        }
    }//GEN-LAST:event_jMenuItemRedoActionPerformed

    private void jMenuItemClearTextAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClearTextAreaActionPerformed
        jTextArea.setText("");
    }//GEN-LAST:event_jMenuItemClearTextAreaActionPerformed

    private void jMenuItemUndoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUndoAllActionPerformed
        if (! UNDO) {
            jTextArea.append("Undo All is not yet implemented.\n");
        } else {
//# BEGIN TODO Undo all
            undoRedo.undoAll(true);
//# END TODO
            updateFrame();
        }
    }//GEN-LAST:event_jMenuItemUndoAllActionPerformed

    private void jMenuItemRedoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRedoAllActionPerformed
        if (! UNDO) {
            jTextArea.append("Redo All is not yet implemented.\n");
        } else {
//# BEGIN TODO Redo all
            undoRedo.redoAll();
//# END TODO
            updateFrame();
        }
    }//GEN-LAST:event_jMenuItemRedoAllActionPerformed

    private void jMenuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpActionPerformed
        JOptionPane.showMessageDialog(this,
                new String[] {
                    "A Kakuro Puzzle consists of a rectangular grid of cells.",
                    "A group of horizontally or vertically adjacent emtpy cells",
                    "forms an entry.",
                    " ",
                    "Rule 1:",
                    "  Enter one positive digit (1 - 9) in each empty cell.",
                    " ",
                    "Rule 2:",
                    "  Within an entry, the digits must be distinct.",
                    " ",
                    "Rule 3:",
                    "  The sum of the digits in an entry is prescribed by its",
                    "  hint, appearing on its left, or above it.",
                    " ",
                    "Rule 4:",
                    "  There is exactly one solution."
                },
                "Help for Kakuro Puzzle Assistant", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItemHelpActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        JOptionPane.showMessageDialog(this,
                new String[] {
                    "Author: Tom Verhoeff (TU/e, Eindhoven University of Technology)",
                    "Copyright 2013-2-16"
                },
                "About Kakuro Puzzle Assistant", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jCheckBoxMenuItemHighlightItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemHighlightItemStateChanged
        updateFrame();
    }//GEN-LAST:event_jCheckBoxMenuItemHighlightItemStateChanged

    private void jMenuItemApplyReasoningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemApplyReasoningActionPerformed
        String message;
        Reasoner reasoner = null;
//# BEGIN TODO Optionally, configure a reasoning strategy
        reasoner = new EntryWithOneEmptyCell(puzzle);
//# END TODO
        if (reasoner == null) {
            message = "Apply Reasoning is not yet implemented.";
        } else {
            if (! jCheckBoxMenuItemStopAtFirstChange.isSelected()) {
                reasoner = new FixpointReasoner(puzzle, reasoner);
            }
            CompoundCommand command = reasoner.apply();
            if (command == null) {
                message = "Puzzle is not solvable.";
            } else if (command.size() > 0) {
                this.undoRedo.did(command);
                message = "Reasoning determined " + command.getCells().size() + " cells.";
            } else {
                message = "Reasoning did not help.";
            }
        }
        jTextArea.append(message + "\n");
        updateFrame();
    }//GEN-LAST:event_jMenuItemApplyReasoningActionPerformed

    private void jMenuItemSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSolveActionPerformed
        if (puzzle == null) {
            return;
        }
        // puzzle != null

        String message;
        Reasoner reasoner = null;
        Reasoner fixpoint = null;
        AbstractSolver solver = null;
//# BEGIN TODO Configure and invoke solver
        reasoner = new EntryWithOneEmptyCell(puzzle);
        fixpoint = new FixpointReasoner(puzzle, reasoner);
        solver = new BacktrackSolver(puzzle, fixpoint);
//# END TODO
        if (solver == null) {
            message = "Solve is not yet implemented.";
        } else if (solver.solve()) {
            message = "Puzzle solved";
            // handle result of solver
            final Collection<Command> commands = solver.getCommands();
            message = message + ": " + commands.size() + " steps";
            for (final Command command : commands) {
                if (command instanceof CompoundCommand &&
                        ((CompoundCommand) command).size() == 0) {
                    continue;
                }
                undoRedo.did(command);
            }
        } else {
            message = "Puzzle not solvable";
        }
        jTextArea.append(message + "\n");
        updateFrame();
    }//GEN-LAST:event_jMenuItemSolveActionPerformed

    private void jCheckBoxMenuItemStopAtFirstChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemStopAtFirstChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMenuItemStopAtFirstChangeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemHighlight;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemStopAtFirstChange;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemApplyStrategies;
    private javax.swing.JMenuItem jMenuItemClear;
    private javax.swing.JMenuItem jMenuItemClearTextArea;
    private javax.swing.JMenuItem jMenuItemCopy;
    private javax.swing.JMenuItem jMenuItemDump;
    private javax.swing.JMenuItem jMenuItemHelp;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemQuit;
    private javax.swing.JMenuItem jMenuItemRedo;
    private javax.swing.JMenuItem jMenuItemRedoAll;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JMenuItem jMenuItemSolve;
    private javax.swing.JMenuItem jMenuItemUndo;
    private javax.swing.JMenuItem jMenuItemUndoAll;
    private javax.swing.JMenu jMenuPuzzle;
    private kpa.gui.PuzzlePanel jPanelPuzzle;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemEdit;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemSolve;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparatorEdit1;
    private javax.swing.JPopupMenu.Separator jSeparatorEdit2;
    private javax.swing.JPopupMenu.Separator jSeparatorFile1;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables

    /** Whether to provide Undo. */
    public static final boolean UNDO = true; // TODO: implement true

    /** Default directory for loading of puzzles. */
    public static final File DEFAULT_PUZZLE_DIRECTORY =
            new File(new File(".."), "puzzles");

    /** The puzzle being solved, or null if no puzzle loaded. */
    private KPuzzle puzzle = null;

    /** The puzzle panel. */
    private final PuzzlePanel puzzlePanel;

   /** The file chooser for open and save dialogs. */
    private final JFileChooser puzzleChooser = new JFileChooser();

    /** Whether there are unsaved modifications to the puzzle. */
    private boolean unsavedModifications = false;

//# BEGIN TODO Undo-redo facility (via composition)
    private final UndoRedo undoRedo = new UndoRedo();
//# END TODO

    /**
     * Completes initialization of this frame.
     */
    private void initFrame() {
        puzzleChooser.setCurrentDirectory(DEFAULT_PUZZLE_DIRECTORY);
        puzzle = null;
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Kakuro puzzle files", "zgr");
        puzzleChooser.setFileFilter(filter);
        this.setTitle("Kakuro Puzzle Assistant: No puzzle loaded");
        this.jTextArea.append("Open a puzzle file to start.\n");
        updateFrame();
    }

    /**
     * Updates this frame, that is, the visual state of controller,
     * and repaints the view.
     */
    private void updateFrame() {
        jMenuItemSaveAs.setEnabled(puzzle != null);

        if (UNDO) {
//# BEGIN TODO Conditionally enable undo/redo menu items
            jMenuItemUndo.setEnabled(true);
            jMenuItemUndoAll.setEnabled(true);
            jMenuItemRedo.setEnabled(true);
            jMenuItemRedoAll.setEnabled(true);
//# END TODO

            jPanelPuzzle.setHighlight(
                    jCheckBoxMenuItemHighlight.getState());

            final Collection<KCell> markedCells = new HashSet<>();
//# BEGIN TODO If available, set markedCells to cells involved in last command
            if (undoRedo.canUndo()) {
                markedCells.addAll(undoRedo.lastDone().getCells());
            }
//# END TODO
            puzzlePanel.setMarkedCells(markedCells);
        }

        jPanelPuzzle.invalidate();
        repaint();
    }

    /**
     * Confirms whether the unsaved modifications can be discarded.
     *
     * @return whether unsaved modifications can be discarded
     */
    private boolean confirmDiscard() {
        if (! unsavedModifications) {
            return true;
        }
        int response = JOptionPane.showConfirmDialog(this,
                "Discard unsaved modifications?",
                "Confirm Discard Unsaved Modifications",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return response == JOptionPane.OK_OPTION;
    }

    /**
     * Updates the mode radio buttons in the Edit menu, and the puzzle's mode.
     *
     * @param mode  the new mode
     */
    private void updateModeRadioButtons(final KPuzzle.Mode mode) {
        if (puzzle == null) {
            jRadioButtonMenuItemView.setSelected(false);
            jRadioButtonMenuItemSolve.setSelected(false);
            jRadioButtonMenuItemEdit.setSelected(false);
            return;
        }
        // puzzle != null
        jRadioButtonMenuItemView.setSelected(mode == KPuzzle.Mode.VIEW);
        jRadioButtonMenuItemSolve.setSelected(mode == KPuzzle.Mode.SOLVE);
        jRadioButtonMenuItemEdit.setSelected(mode == KPuzzle.Mode.EDIT);
        puzzle.setMode(mode);
        jTextArea.append("Mode changed to " + puzzle.getMode() + "\n");
    }

}
//# END SKELETON