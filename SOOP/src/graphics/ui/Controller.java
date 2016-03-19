package graphics.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.ui.ShapesView;
import graphics.shapes.attributes.SelectionAttributes;

public class Controller implements MouseListener, MouseMotionListener, KeyListener
{
	private Object model;
	private View view;

	public Controller(Object newModel)
	{
		model = newModel;
	}

	public void setView(View view)
	{
		this.view = view;
	}

	final public View getView()
	{
		return this.view;
	}

	public void setModel(Object model)
	{
		this.model = model;
	}

	public Object getModel()
	{
		return this.model;
	}

	public void mousePressed(MouseEvent e)
	{
	}

	public void mouseReleased(MouseEvent e)
	{
		System.out.println(e.toString());
		for (Iterator<Shape> it = ((SCollection) model).iterator(); it.hasNext();)
		{
			Shape shape = it.next();
			SelectionAttributes selection = (SelectionAttributes) shape.getAttributes("selection");
			if (shape.getBounds().contains(e.getX(), e.getY()))
			{
				selection.select(shape);
				((ShapesView) this.view).paintComponent(this.view.getGraphics());
			}
			else if (selection.isSelected())
			{
				selection.unselect(shape);
				((ShapesView) this.view).paintComponent(this.view.getGraphics());
			}
		}
	}

	public void mouseClicked(MouseEvent e)
	{
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mouseMoved(MouseEvent evt)
	{
	}

	public void mouseDragged(MouseEvent evt)
	{
		// translate
	}

	public void keyTyped(KeyEvent evt)
	{
		// CTRL

		// SUPPR
	}

	public void keyPressed(KeyEvent evt)
	{
	}

	public void keyReleased(KeyEvent evt)
	{
	}
}
