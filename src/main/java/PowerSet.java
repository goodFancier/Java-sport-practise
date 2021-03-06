import java.util.ArrayList;
import java.util.List;

public class PowerSet
{
		private List<String> set;

		public List<String> getSet()
		{
				return set;
		}

		public void setSet(List<String> set)
		{
				this.set = set;
		}

		public PowerSet()
		{
				// ваша реализация хранилища
				set = new ArrayList<>();
		}

		public int size()
		{
				// количество элементов в множестве
				return set.size();
		}

		public void put(String value)
		{
				// всегда срабатывает
				if(!get(value))
						set.add(value);
		}

		public boolean get(String value)
		{
				// возвращает true если value имеется в множестве,
				// иначе false
				return set.contains(value);
		}

		public boolean remove(String value)
		{
				// возвращает true если value удалено
				// иначе false
				if(get(value))
				{
						set.remove(value);
						return true;
				}
				return false;
		}

		public PowerSet intersection(PowerSet set2)
		{
				// пересечение текущего множества и set2
				List<String> resultList = new ArrayList<>();
				for(String element : set2.set)
				{
						if(get(element))
								resultList.add(element);
				}
				PowerSet intersectionSet = new PowerSet();
				intersectionSet.set = resultList;
				return intersectionSet;
		}

		public PowerSet union(PowerSet set2)
		{
				// объединение текущего множества и set2
				PowerSet resultSet = new PowerSet();
				resultSet.set.addAll(this.set);
				for (String element : set2.set)
				{
						if (!this.get(element))
								resultSet.set.add(element);
				}
				return resultSet;
		}

		public PowerSet difference(PowerSet set2)
		{
				// разница текущего множества и set2
				List<String> listOfDiff = new ArrayList<>();
				for(String element : this.set)
				{
						if(!set2.get(element))
								listOfDiff.add(element);
				}
				PowerSet resultSet = new PowerSet();
				resultSet.set = listOfDiff;
				return resultSet;
		}

		public boolean isSubset(PowerSet set2)
		{
				// возвращает true, если set2 есть
				// подмножество текущего множества,
				// иначе false
				return set.containsAll(set2.set);
		}
}
