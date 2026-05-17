
# Втора лабораториска вежба по Софтверско инженерство
## Марта Величковиќ 223178
### Control Flow Graph
*searchBookByTitle*

<img width="545" height="924" alt="searchBookByTitle drawio" src="https://github.com/user-attachments/assets/f1e55d8d-a054-485a-ad17-4919923f3677" />




*borrowBook*

<img width="569" height="919" alt="borrowBook drawio" src="https://github.com/user-attachments/assets/22eb5f5a-95df-4b91-8315-1d1764d24355" />


### Цикломатска комплексност
Цикломатската комплексност за searchBookByTitle е 5, истата ја добив преку формулата P+1 каде што P е бројот на предикатни јазли. Во случајов P=4 па цикломатската комплексност изнесува 5.

Цикломатската комплексност за borrowBook е 5, истата ја добив преку формулата P+1 каде што P е бројот на предикатни јазли. Во случајов P=4 па цикломатската комплексност изнесува 5.

### Тест случаи според критериумот Every Statement
|       | Test 1 | Test 2 | Test 3 |
|---|---|---|---|
| `title.isEmpty()` | * | * | * |
| `throw IllegalArgumentException` | * |  |  |
| `results = new ArrayList` |  | * | * |
| `results.add(book)` |  | * |  |
| `results.isEmpty()` |  | * | * |
| `return null` |  |  | * |
| `return results` |  | * |  |

Минимален број на тест случаи за оваа функција според Every Statement критериумот е 3.

1: library.searchBookByTitle("")

2: library.searchBookByTitle("Clean Code")

3: library.searchBookByTitle("Harry Potter")


### Тест случаи според критериумот Every Branch
|   | Test 1 | Test 2 | Test 3 | Test 4 |
|---|---|---|---|---|
| Invalid search query | * |  |  |  |
| Book found |  | * | * |  |
| Book not borrowed |  | * |  |  |
| Book already borrowed |  |  | * |  |
| Book not found |  |  |  | * |

Минимален број на тест случаи за оваа функција според Every Branch критериумот е 4.

1: library.borrowBook("", "Robert Martin")

2: library.borrowBook("Clean Code", "Robert Martin")

3: library.borrowBook("Clean Code", "Robert Martin")

4: library.borrowBook("Unknown", "Unknown")

### Тест случаи според критериумот Multiple Condition

*searchBookByTitle*

***Услов: book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()***
|   | Test |
|---|---|
| T T | Book exists and not borrowed |
| T F | Book exists but borrowed |
| F T | Different title and available book |
| F F | Different title and borrowed book |

Минимален број тест случаи e 4.

*borrowBook*

***Услов: title.isEmpty() || author.isEmpty()***
|   | Test |
|---|---|
| T T | `title="" , author=""` |
| T F | `title="" , author="Robert"` |
| F T | `title="Clean Code" , author=""` |
| F F | `title="Clean Code" , author="Robert"` |

Минимален број тест случаи e 4.


