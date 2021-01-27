package de.relluem94.relluedit.functions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class CubePanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final int D_W = 400;
    private static final int D_H = 300;

    Cube cube;

    public CubePanel() {
        cube = new Cube(200, 200, 50, 15);
        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke("RIGHT"), "shiftRight");
        getActionMap().put("shiftRight", new AbstractAction() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (cube.x < 423) {
                    cube.shiftRight();
                    repaint();
                }
            }
        });
        im.put(KeyStroke.getKeyStroke("LEFT"), "shiftLeft");
        getActionMap().put("shiftLeft", new AbstractAction() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {

                if (cube.x > 0) {
                    cube.shiftLeft();
                    repaint();
                }

            }
        });

        im.put(KeyStroke.getKeyStroke("UP"), "shiftUp");
        getActionMap().put("shiftUp", new AbstractAction() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (cube.y > 0) {
                    cube.shiftUp();
                    repaint();
                }
            }
        });
        im.put(KeyStroke.getKeyStroke("DOWN"), "shiftDown");
        getActionMap().put("shiftDown", new AbstractAction() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (cube.y < 401) {
                    cube.shiftDown();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        cube.drawCube(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public class Cube {

        private static final int SHIFT_INC = 5;
        int x, y, size, shift;
        Point[] cubeOnePoints;
        Point[] cubeTwoPoints;

        public Cube(int x, int y, int size, int shift) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.shift = shift;
            cubeOnePoints = getCubeOnePoints();
            cubeTwoPoints = getCubeTwoPoints();
        }

        private Point[] getCubeOnePoints() {
            Point[] points = new Point[4];
            points[0] = new Point(x, y);
            points[1] = new Point(x + size, y);
            points[2] = new Point(x + size, y + size);
            points[3] = new Point(x, y + size);
            return points;
        }

        private Point[] getCubeTwoPoints() {
            int newX = x + shift;
            int newY = y + shift;
            Point[] points = new Point[4];
            points[0] = new Point(newX, newY);
            points[1] = new Point(newX + size, newY);
            points[2] = new Point(newX + size, newY + size);
            points[3] = new Point(newX, newY + size);
            return points;
        }

        public void shiftLeft() {
            x -= SHIFT_INC;
            for (Point p : cubeOnePoints) {
                p.x -= SHIFT_INC;
            }
            for (Point p : cubeTwoPoints) {
                p.x -= SHIFT_INC;
            }
        }

        public void shiftDown() {
            y += SHIFT_INC;
            for (Point p : cubeOnePoints) {
                p.y += SHIFT_INC;
            }
            for (Point p : cubeTwoPoints) {
                p.y += SHIFT_INC;
            }
        }

        public void shiftUp() {
            y -= SHIFT_INC;
            for (Point p : cubeOnePoints) {
                p.y -= SHIFT_INC;
            }
            for (Point p : cubeTwoPoints) {
                p.y -= SHIFT_INC;
            }
        }

        public void shiftRight() {
            x += SHIFT_INC;
            for (Point p : cubeOnePoints) {
                p.x += SHIFT_INC;
            }
            for (Point p : cubeTwoPoints) {
                p.x += SHIFT_INC;
            }
        }

        public void drawCube(Graphics g) {
            g.setColor(Color.darkGray);
            g.drawRect(x, y, size, size);
            g.drawRect(x + shift, y + shift, size, size);

            for (int i = 0; i < 4; i++) {
                g.setColor(Color.gray);
                g.fillRect(cubeOnePoints[i].x, cubeOnePoints[i].y, 16, 16);

            }
        }
    }


}
