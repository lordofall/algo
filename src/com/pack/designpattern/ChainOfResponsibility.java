package com.pack.designpattern;
/**
 * A chain of components who all get a chance to process a command
 * or query, optionally having default processing implementation and
 * an ability to terminate the processing chain.
 * @author LordOfAll
 *
 */
class ChainOfResponsibility {
	public static void main(String[] args) {
		Creature goblin = new Creature("goblin", 2, 2);
		
		CreatureModifier root = new CreatureModifier(goblin);
		root.add(new DoubleAttackModifer(goblin));
		root.add(new IncreaseDefenseModifier(goblin));
		root.handle();
		System.out.println(goblin);
	}
}

class Creature {
	public String name;
	public int attack, defense;
	public Creature(String name, int attack, int defense) {
		super();
		this.name = name;
		this.attack = attack;
		this.defense = defense;
	}
	@Override
	public String toString() {
		return "Creature [name=" + name + ", attack=" + attack + ", defense=" + defense + "]";
	}
}


class CreatureModifier {
	protected Creature creature;
	protected CreatureModifier next;
	public CreatureModifier(Creature creature) {
		super();
		this.creature = creature;
	}
	
	public void add(CreatureModifier cm) {
		if(next != null) {
			next.add(cm); // recursive call
		}
		else next = cm;
	}
	
	public void handle() {
		if(next != null) next.handle();
		System.out.println("cm: "+creature);
	}
}

class DoubleAttackModifer extends CreatureModifier {

	public DoubleAttackModifer(Creature creature) {
		super(creature);
	}

	@Override
	public void handle() {
		creature.attack *=2;
		System.out.println("dacm: "+creature);
		super.handle();
	}
}

class IncreaseDefenseModifier extends CreatureModifier {

	public IncreaseDefenseModifier(Creature creature) {
		super(creature);
	}

	@Override
	public void handle() {
		creature.defense +=3;
		System.out.println("idcm: "+creature);
		super.handle();
	}
}