<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>電卓</title>
    <style>
        /* 全体の画面中央配置 */
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;  /* 画面全体の高さ */
            margin: 0;
            background-color: #f4f4f4;
        }
        
        /* フォームのスタイル */
        table {
            border-collapse: collapse;
            background-color: #fff;
            padding: 10px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }
        
        td {
            padding: 10px;
            text-align: center;
        }

        /* ボタンのスタイル */
        button {
            width: 50px;
            height: 50px;
            font-size: 18px;
            cursor: pointer;
        }

        /* 入力フィールドのスタイル */
        input[type="text"] {
            width: 100%;
            height: 50px;
            font-size: 20px;
            text-align: right;
            padding: 5px;
            box-sizing: border-box;
        }
        
        h1, h2 {
            text-align: center;
        }

        table.history {
            margin-top: 20px;
            width: 100%;
        }

        table.history td {
            padding: 5px;
        }
    </style>
</head>
<body>
    <div>
        <h1>電卓</h1>
        <form action="keisanservlet" method="POST">
            <table border="1">
                <tr>
                    <td colspan="4">
                        <input type="text" name="gamen" value="${gamen}" readonly>
                    </td>
                </tr>
                <tr>
                    <td><button type="submit" name="kazu" value="7">7</button></td>
                    <td><button type="submit" name="kazu" value="8">8</button></td>
                    <td><button type="submit" name="kazu" value="9">9</button></td>
                    <td><button type="submit" name="kigo" value="/">/</button></td>
                </tr>
                <tr>
                    <td><button type="submit" name="kazu" value="4">4</button></td>
                    <td><button type="submit" name="kazu" value="5">5</button></td>
                    <td><button type="submit" name="kazu" value="6">6</button></td>
                    <td><button type="submit" name="kigo" value="*">*</button></td>
                </tr>
                <tr>
                    <td><button type="submit" name="kazu" value="1">1</button></td>
                    <td><button type="submit" name="kazu" value="2">2</button></td>
                    <td><button type="submit" name="kazu" value="3">3</button></td>
                    <td><button type="submit" name="kigo" value="-">-</button></td>
                </tr>
                <tr>
                    <td><button type="submit" name="kazu" value="0">0</button></td>
                    <td><button type="submit" name="re" value="C">C</button></td>
                    <td><button type="submit" name="equal" value="=">=</button></td>
                    <td><button type="submit" name="kigo" value="+">+</button></td>
                </tr>
            </table>
        </form>

        <h2>計算履歴</h2>
        <table border="1" class="history">
            <tr>
                <td>計算式</td>
                <td>解</td>
            </tr>
            <% ArrayList<String> history = (ArrayList<String>) session.getAttribute("history");
               ArrayList<String> history_siki = (ArrayList<String>) session.getAttribute("history_siki");
               if (history_siki == null) {
                    history_siki = new ArrayList<>();
                }
                if (history != null && !history.isEmpty()) {
                    for (int i = 0; i < history.size(); i++) {
            %>
            <tr>
                <td><%= history_siki.get(i) %></td>
                <td><%= history.get(i) %></td>
            </tr><%  
                    }
                } else { %> 
            <tr><td colspan="2">履歴はありません。</td></tr>
             <%  }  %>
        </table>
    </div>
</body>
</html>
